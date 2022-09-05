package com.assessment.skedulo.structuer.presenter

/**
 * **  this interface is used to link the presenter and the view
 */
interface Presenter<V> {

    fun init()

    /**
     * Method to attach view to presenter
     */
    fun attachView(view: V)

    /**
     * Method to detach view from presenter
     */

    fun detachView()

    fun onDestroy()

}