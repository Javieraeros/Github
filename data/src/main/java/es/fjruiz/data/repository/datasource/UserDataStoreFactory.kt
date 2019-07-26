package es.fjruiz.data.repository.datasource

import es.fjruiz.data.net.RestApi
import es.fjruiz.data.repository.datasource.source.UserDataStore
import es.fjruiz.data.repository.datasource.source.cloud.UserCloudDataStore
import javax.inject.Inject


class UserDataStoreFactory @Inject constructor(private val restApi: RestApi) {
    //region Static variables
    companion object {
        private val TAG = UserDataStoreFactory::class.java.simpleName
    }
    //endregion

    //region Fields
    // TODO 22/07/19 Add cache
    private val userCloudDataStore: UserDataStore by lazy { UserCloudDataStore(restApi) }
    //endregion

    //region Methods


    fun createCloud() = userCloudDataStore
    //endregion

    //region Inner classes

    //endregion
}
