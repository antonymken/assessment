package com.assessment.skedulo.domain.searchuser

import com.assessment.skedulo.domain.github.model.GithubUserQueryModel
import com.assessment.skedulo.domain.github.usecase.GetGithubUserListUseCase
import com.assessment.skedulo.structuer.domain.Error
import com.assessment.skedulo.structuer.domain.Success
import com.assessment.skedulo.structuer.presenter.BasePresenter
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SearchUserPresenter @Inject constructor(
    private val getGithubUserListUseCase: GetGithubUserListUseCase,
    coroutineContext: CoroutineContext
) : BasePresenter<SearchUserView>(coroutineContext) {

    private var searchJob: Job? = null

    suspend fun query(query: String) {
        searchJob?.cancel()
        searchJob = launch(coroutineContext) {
            delay(1000)
            searchUser(query)
        }
    }

    private suspend fun searchUser(query: String) {
        view?.showLoadingState()
        when (val result = getGithubUserListUseCase.execute(GithubUserQueryModel(query, RESULTS_PER_PAGE))) {
            is Error -> {
                view?.showErrorState("failed to get users")
            }
            is Success -> {
                view?.showUsers(result.data)
            }

        }
    }

    companion object {
        const val RESULTS_PER_PAGE = 100
    }
}
