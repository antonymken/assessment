package com.assessment.skedulo.domain.searchuser

import com.assessment.skedulo.domain.github.model.GithubUserDomainModel


interface SearchUserView {
    fun showUsers(users: List<GithubUserDomainModel>)
    fun showErrorState(errorMessage: String)
    fun showLoadingState()
}