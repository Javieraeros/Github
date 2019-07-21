package es.fjruiz.data.net

import es.fjruiz.data.entity.UserEntity

interface RestApi {
    suspend fun getUsers(organizationName: String): List<UserEntity>
}