package es.fjruiz.data.repository.datasource.source

import es.fjruiz.data.entity.UserEntity

interface UserDataStore {
    suspend fun getUsers(organizationName: String): List<UserEntity>
}