package com.assessment.skedulo.domain.main

import com.assessment.skedulo.structuer.presenter.BasePresenter
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(coroutineContext: CoroutineContext) : BasePresenter<MainView>(coroutineContext)
