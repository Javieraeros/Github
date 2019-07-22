package es.fjruiz.data.entity

data class UserDetailEntity(
    val id: Long,
    val nickname: String,
    val name: String?,
    val image: String,
    val repos: List<RepositoryEntity>
)