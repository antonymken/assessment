package com.assessment.skedulo.structuer.presenter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * **  this class connects presenter with view
 */
abstract class BasePresenter<V> : Presenter<V>, CoroutineScope {

    protected val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    protected var view: V? = null
        private set

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    //stubs for default implementation
    override fun init() {
        //no-op
    }

    override fun onDestroy() {
        //no-op
    }
}