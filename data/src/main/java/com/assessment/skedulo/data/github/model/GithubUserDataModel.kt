package com.assessment.skedulo.data.github.model

import com.squareup.moshi.Json


class GithubUserDataModel(
    @Json(name = "items")
    var items: MutableList<UserItemDataModel>
){
    class UserItemDataModel(
        @Json(name = "id")
        val id: Int,
        @Json(name = "login")
        val login: String?,
        @Json(name = "type")
        val type: String?,
        @Json(name = "score")
        val score: Float?
    )
}