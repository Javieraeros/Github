package es.fjruiz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Long,
    @SerializedName("login")
    val nickname: String,
    @SerializedName("name")
    val name: String?,
    @SerializedName("avatar_url")
    val image: String)