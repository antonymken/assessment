package com.assessment.skedulo.ui.searchuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.assessment.skedulo.domain.github.model.GithubUserDomainModel
import com.assessment.skedulo.structuerandroid.PresenterViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchUserViewModel @Inject constructor(presenter: SearchUserPresenter) :
    PresenterViewModel<SearchUserView, SearchUserPresenter>(presenter),
    SearchUserView {

    private val _githubUserListMutableLiveData: MutableLiveData<List<GithubUserDomainModel>> =
        MutableLiveData()
    val githubUserListLiveData: LiveData<List<GithubUserDomainModel>> =
        _githubUserListMutableLiveData

    private val _errorMessageMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val errorMessageLiveData: LiveData<String> = _errorMessageMutableLiveData

    private val _loadingStateMutableLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply { false }
    val loadingStateLiveData: LiveData<Boolean> = _loadingStateMutableLiveData

    override fun getPresenterView(): SearchUserView = this

    override fun showUsers(users: List<GithubUserDomainModel>) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _loadingStateMutableLiveData.value = false
                _githubUserListMutableLiveData.value = users
            }
        }
    }

    override fun showErrorState(errorMessage: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _loadingStateMutableLiveData.value = false
                _errorMessageMutableLiveData.value = errorMessage
            }
        }
    }

    override fun showLoadingState() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _loadingStateMutableLiveData.value = true
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        if (query.length > 2) {
            viewModelScope.launch {
                presenter.query(query)
            }
        }

        if (query.isEmpty()) {
            _githubUserListMutableLiveData.value = emptyList()
        }
    }

}