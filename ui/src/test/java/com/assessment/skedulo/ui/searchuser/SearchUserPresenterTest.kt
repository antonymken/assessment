package com.assessment.skedulo.ui.searchuser

import com.assessment.skedulo.domain.github.usecase.GetGithubUserListUseCase
import com.assessment.skedulo.domain.searchuser.SearchUserPresenter
import com.assessment.skedulo.domain.searchuser.SearchUserView
import com.assessment.skedulo.structuer.domain.Error
import com.assessment.skedulo.structuer.domain.Success
import com.assessment.skedulo.ui.BaseUnitTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


internal class SearchUserPresenterTest : BaseUnitTest() {

    @Mock
    lateinit var mockGetGithubUserListUseCase: GetGithubUserListUseCase

    @Mock
    lateinit var mockSearchUserView: SearchUserView

    lateinit var searchUserPresenter: SearchUserPresenter

    override fun testSetup() {
        searchUserPresenter = SearchUserPresenter(mockGetGithubUserListUseCase, Dispatchers.Main)
        searchUserPresenter.attachView(mockSearchUserView)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun should_show_success_when_success_result() = runBlockingTest(dispatcher) {
        whenever(mockGetGithubUserListUseCase.execute(any())).thenReturn(Success(emptyList()))

        searchUserPresenter.query("")
        advanceTimeBy(1000)
        verify(mockSearchUserView).showLoadingState()
        verify(mockSearchUserView).showUsers(any())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun should_show_error_when_error_result() = runTest(dispatcher) {
        whenever(mockGetGithubUserListUseCase.execute(any())).thenReturn(Error(Exception("error")))
        searchUserPresenter.query("")
        advanceTimeBy(1100)
        verify(mockSearchUserView).showErrorState(any())
    }

}