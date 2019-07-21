package es.fjruiz.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey
                      val id: Long)