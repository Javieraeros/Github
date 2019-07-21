package es.fjruiz.data.repository.datasource.source.cloud

import es.fjruiz.data.entity.UserEntity
import es.fjruiz.data.net.RestApi
import es.fjruiz.data.repository.datasource.source.UserDataStore

class UserCloudDataStore constructor(private val restApi: RestApi): UserDataStore {

    //region Static

    //endregion

    //region Inject

    //endregion

    //region Bind

    //endregion

    //region Fields

    //endregion

    //region Constructors & Initialization

    //endregion

    //region Methods for/from SuperClass/Interfaces
    override suspend fun getUsers(organizationName: String): List<UserEntity> {
        return restApi.getUsers(organizationName)
    }
    //endregion

    //region Methods

    //endregion

    //region Private methods

    //endregion

    //region Inner and Anonymous Classes

    //endregion

    //region Getter & Setter

    //endregion


}