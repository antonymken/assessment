package com.assessment.skedulo.domain.github.usecase

import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.domain.github.model.GithubUserQueryModel
import com.assessment.skedulo.domain.github.repository.GithubRepository
import com.assessment.skedulo.structuer.domain.BaseCoroutineUseCase
import com.assessment.skedulo.structuer.domain.Result
import javax.inject.Inject

class GetGithubUserListUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) : BaseCoroutineUseCase<GithubUserQueryModel?, Result<List<GithubUserDomainModel>>>() {

    override fun executeUseCase(requestValues: GithubUserQueryModel?): Result<List<GithubUserDomainModel>> {
        return githubRepository.getUsers(requestValues ?: GithubUserQueryModel(""))
    }

}