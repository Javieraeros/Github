package es.fjruiz.domain.repository

import es.fjruiz.domain.bo.User
import es.fjruiz.domain.bo.UserDetail

interface UserRepository {
    // TODO: 26/07/19
    //  Don't send the List/ model directly, wrap it into a Status model
    suspend fun getUsers(organizationName: String): List<User>

    suspend fun getUserRepos(user: User): UserDetail
}