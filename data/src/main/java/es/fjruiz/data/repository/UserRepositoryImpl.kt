package es.fjruiz.data.repository

import es.fjruiz.data.entity.mapper.UserMapper
import es.fjruiz.data.repository.datasource.UserDataStoreFactory
import es.fjruiz.domain.bo.User
import es.fjruiz.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataFactory: UserDataStoreFactory): UserRepository {

    //region Static

    //endregion

    //region Constants

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
    override suspend fun getUsers(organizationName: String): List<User> {
        return dataFactory.createCloud().getUsers(organizationName).map {
            UserMapper.transform(it)
        }
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