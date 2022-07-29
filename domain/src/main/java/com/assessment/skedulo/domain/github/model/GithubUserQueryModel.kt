package com.assessment.skedulo.domain.github.model


data class GithubUserQueryModel(
    val query: String,
    val perPage: Int = 10,
    val pageCount: Int = 1
)