package es.fjruiz.domain.repository

import es.fjruiz.domain.bo.User

interface BaseRepository {
    suspend fun getUsers(): List<User>
}