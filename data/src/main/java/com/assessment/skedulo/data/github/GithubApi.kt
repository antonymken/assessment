package com.assessment.skedulo.data.github

import com.assessment.skedulo.data.github.model.GithubUserDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface GithubApi {

    companion object {
        const val SEARCH_GITHUB = "/search/{path}"
        const val TOKEN = "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"
    }

    @Headers(
        value = [
            "Accept: application/json",
            "Authorization: Bearer $TOKEN"
        ]
    )

    @GET(SEARCH_GITHUB)
    fun getUsers(
        @Path("path") path: String,
        @Query(value = "q", encoded = true) query: String,
        @Query(value = "type") type: String,
        @Query(value = "per_page") perPage: Int,
        @Query(value = "page") pageCount: Int
    ): Call<GithubUserDataModel>

}