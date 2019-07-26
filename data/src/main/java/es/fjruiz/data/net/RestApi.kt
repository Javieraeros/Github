package es.fjruiz.data.net

import es.fjruiz.data.entity.RepositoryEntity
import es.fjruiz.data.entity.UserEntity

interface RestApi {
    // TODO: 26/07/19 Change entity with Response, and wrap it into another model
    suspend fun getUsers(organizationName: String): List<UserEntity>

    suspend fun getUserRepos(userName: String): List<RepositoryEntity>
}