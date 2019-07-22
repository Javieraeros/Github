package es.fjruiz.domain.bo

data class Repository(val id: Long,
                      val name: String,
                      val description: String?,
                      var language: String?,
                      val stars: Int,
                      val fork: Boolean,
                      val forksCount: Int)