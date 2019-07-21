package es.fjruiz.domain.repository

import es.fjruiz.domain.bo.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}