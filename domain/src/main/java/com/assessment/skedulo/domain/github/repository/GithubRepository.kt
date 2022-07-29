package com.assessment.skedulo.domain.github.repository

import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.domain.github.model.GithubUserQueryModel
import com.assessment.skedulo.structuer.domain.Result


interface GithubRepository {
    fun getUsers(githubUserQueryModel: GithubUserQueryModel): Result<List<GithubUserDomainModel>>
}