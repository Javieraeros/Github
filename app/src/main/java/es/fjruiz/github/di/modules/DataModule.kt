package es.fjruiz.github.di.modules

import dagger.Module
import dagger.Provides
import es.fjruiz.data.net.RestApi
import es.fjruiz.data.net.RestApiImpl
import javax.inject.Singleton

@Module
class DataModule {

    //region Api

    @Provides
    @Singleton
    fun provideRestApi(): RestApi {
        return RestApiImpl()
    }
    //endregion

    //region Cache

    //endregion

    //region DataStore

    //endregion

    //region

    //region Repository

    //endregion

    //region Storage

    //endregion


}