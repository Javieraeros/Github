package es.fjruiz.data.net

import es.fjruiz.data.entity.RepositoryEntity
import es.fjruiz.data.entity.UserEntity

interface RestApi {
    suspend fun getUsers(organizationName: String): List<UserEntity>

    suspend fun getUserRepos(userName: String): List<RepositoryEntity>
}