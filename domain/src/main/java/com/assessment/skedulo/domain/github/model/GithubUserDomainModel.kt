package com.assessment.skedulo.domain.github.model


data class GithubUserDomainModel(
    val id: Int,
    val login: String,
    val type: String,
    val score: Float
)