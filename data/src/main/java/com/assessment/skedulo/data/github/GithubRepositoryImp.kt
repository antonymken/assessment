package com.assessment.skedulo.data.github

import com.assessment.skedulo.data.RetrofitClient
import com.assessment.skedulo.data.github.mapper.UserDataModelListToDomainModelList
import com.assessment.skedulo.domain.github.error.HttpException
import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.domain.github.model.GithubUserQueryModel
import com.assessment.skedulo.domain.github.repository.GithubRepository
import com.assessment.skedulo.structuer.domain.Error
import com.assessment.skedulo.structuer.domain.Result
import com.assessment.skedulo.structuer.domain.Success
import java.lang.System.currentTimeMillis
import java.net.URLEncoder
import javax.inject.Inject


class GithubRepositoryImp @Inject constructor() :
    GithubRepository, RetrofitClient() {

    private val githubApi = createApiClient<GithubApi>()
    private var lastCallTime = currentTimeMillis()

    override fun getUsers(githubUserQueryModel: GithubUserQueryModel): Result<List<GithubUserDomainModel>> {
        val queryFilterEncoded = URLEncoder.encode(QUERY_FILTER, "utf-8")

        return try {
            val durationFromLastCall = currentTimeMillis() - lastCallTime
            if (durationFromLastCall < MINIMUM_WAIT_DURATION_5S) {
                Thread.sleep(MINIMUM_WAIT_DURATION_5S - durationFromLastCall)
            }

            val result = githubApi.getUsers(
                path = "users",
                query = "${githubUserQueryModel.query}+$queryFilterEncoded",
                type = "Users",
                perPage = githubUserQueryModel.perPage,
                pageCount = githubUserQueryModel.pageCount
            ).execute()
            lastCallTime = currentTimeMillis()
            if (result.errorBody() == null) {
                Success(
                    UserDataModelListToDomainModelList.transform(
                        result.body()?.items
                    ).toList()
                )
            } else {
                Error(HttpException("Api get github users failed"))
            }

        } catch (e: Exception) {
            Error(e)
        }
    }

    companion object {
        const val QUERY_FILTER = "in:fullname"
        const val MINIMUM_WAIT_DURATION_5S = 5000L
    }
}