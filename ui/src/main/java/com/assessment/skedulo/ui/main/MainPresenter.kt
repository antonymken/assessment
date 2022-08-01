package com.assessment.skedulo.ui.main

import com.assessment.skedulo.structuer.presenter.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(coroutineContext: CoroutineContext) : BasePresenter<MainView>(coroutineContext)
