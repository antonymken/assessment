package com.assessment.skedulo.structuerandroid

import androidx.lifecycle.ViewModel
import com.assessment.skedulo.structuer.presenter.Presenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * **  this class injects the viewModel into the presenter
 */

abstract class PresenterViewModel<V, P : Presenter<V>>(var presenter: P) : ViewModel(){

    abstract fun getPresenterView(): V

    fun onCreate() {
        getPresenterView()?.let { presenter.attachView(it) }
        presenter.init()
    }

    override fun onCleared() {
        presenter.onDestroy()
        presenter.detachView()
    }
}