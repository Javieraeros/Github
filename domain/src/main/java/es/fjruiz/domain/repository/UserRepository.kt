package es.fjruiz.domain.repository

import es.fjruiz.domain.bo.User
import es.fjruiz.domain.bo.UserDetail

interface UserRepository {
    suspend fun getUsers(organizationName: String): List<User>

    suspend fun getUserRepos(user: User): UserDetail
}