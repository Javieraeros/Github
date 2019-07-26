package es.fjruiz.data.entity.mapper

import es.fjruiz.data.entity.RepositoryEntity
import es.fjruiz.data.entity.UserDetailEntity
import es.fjruiz.data.entity.UserEntity
import es.fjruiz.domain.bo.Repository
import es.fjruiz.domain.bo.User
import es.fjruiz.domain.bo.UserDetail

// TODO: 26/07/19 Delete this and make mappings in objects extensions
object UserMapper {

    fun transform(userEntity: UserEntity): User =
        User(
            userEntity.id,
            userEntity.nickname,
            userEntity.name ?: "",
            userEntity.image
        )

    fun transform(repositoryEntity: RepositoryEntity): Repository =
        Repository(
            repositoryEntity.id,
            repositoryEntity.name,
            repositoryEntity.description,
            repositoryEntity.language,
            repositoryEntity.stars,
            repositoryEntity.fork,
            repositoryEntity.forksCount
        )

    fun transform(userDetailEntity: UserDetailEntity): UserDetail =
        UserDetail(userDetailEntity.id, userDetailEntity.nickname, userDetailEntity.name, userDetailEntity.image,
            userDetailEntity.repos.map { transform(it) })
}