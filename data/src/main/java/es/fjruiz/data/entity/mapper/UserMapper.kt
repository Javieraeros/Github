package es.fjruiz.data.entity.mapper

import es.fjruiz.data.entity.UserEntity
import es.fjruiz.domain.bo.User

object UserMapper {

    fun transform(userEntity: UserEntity): User =
        User(userEntity.id,
            userEntity.nickname,
            userEntity.name ?: "",
            userEntity.image)
}