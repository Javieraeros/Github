package es.fjruiz.domain.bo

data class UserDetail(
    val id: Long,
    val nickname: String,
    val name: String?,
    val image: String,
    val repos: List<Repository>
)