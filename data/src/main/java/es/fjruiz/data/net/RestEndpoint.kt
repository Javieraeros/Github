package es.fjruiz.data.net

import es.fjruiz.data.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface RestEndpoint {
    @GET("/orgs/{name}/members")
    suspend fun getUsers(@Path("name") name: String): List<UserEntity>


    @GET("/users/{nickname}")
    suspend fun getUserDetail(@Path("nickname") nickName: String): UserEntity
}