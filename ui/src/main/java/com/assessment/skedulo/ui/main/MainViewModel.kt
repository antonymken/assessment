package com.assessment.skedulo.ui.main

import com.assessment.skedulo.domain.main.MainPresenter
import com.assessment.skedulo.domain.main.MainView
import com.assessment.skedulo.structuerandroid.PresenterViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(presenter: MainPresenter) :
    PresenterViewModel<MainView, MainPresenter>(presenter),
    MainView {

    override fun getPresenterView(): MainView = this


}