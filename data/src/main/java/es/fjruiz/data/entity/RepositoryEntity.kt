package es.fjruiz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RepositoryEntity(@PrimaryKey
                            val id: Long,
                            val name: String,
                            val description: String?,
                            var language: String?,
                            @SerializedName("stargazers_count")
                            val stars: Int,
                            val fork: Boolean,
                            @SerializedName("forks_count")
                            val forksCount: Int)