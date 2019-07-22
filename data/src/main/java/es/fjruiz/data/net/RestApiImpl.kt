package es.fjruiz.data.net

import com.google.gson.GsonBuilder
import es.fjruiz.data.BuildConfig
import es.fjruiz.data.entity.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

class RestApiImpl : RestApi {
    //region Static
    companion object {
        val TAG = RestApiImpl::class.java.simpleName
    }
    //endregion

    //region Inject

    //endregion

    //region Bind

    //endregion

    //region Fields
    private val retrofitAPI: RestEndpoint
    //endregion

    //region Constructors & Initialization
    init {
        val baseUrl = BuildConfig.BASE_URL
        val gson = GsonBuilder()
            .create()
        val gsonConverter = GsonConverterFactory.create(gson)

        val httpInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)

        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 50

        val retrofit = Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(httpInterceptor)
                    .addInterceptor(getHeaderInterceptor())
                    .dispatcher(dispatcher)
                    .build()
            )
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverter)
            .build()
        retrofitAPI = retrofit.create(RestEndpoint::class.java)
    }
    //endregion

    //region Methods for/from SuperClass/Interfaces
    /**
     * Method to retrieve list of users
     * @param organizationName
     * @return
     */
    override suspend fun getUsers(organizationName: String): List<UserEntity> {
        // Mapping in two times to first get the list of deferred users, and then launch all coroutines
        // reducing the time of this function x6
        return retrofitAPI.getUsers(organizationName).map {
            CoroutineScope(coroutineContext).async { retrofitAPI.getUserDetail(it.nickname) }
        }.map { it.await() }
    }
    //endregion

    //region Methods

    //endregion

    //region Private methods
    private fun getHeaderInterceptor(): Interceptor = Interceptor {
        val builder = it.request().newBuilder()
        builder.addHeader("Accept", "application/json")
        builder.addHeader("Authorization", "token ${BuildConfig.GITHUB_TOKEN}")

        it.proceed(builder.build())
    }
    //endregion

}