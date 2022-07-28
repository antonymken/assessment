package com.assessment.skedulo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor() : ViewModel(), Navigation {


    private val _onNavigateBack: MutableLiveData<Unit?> = MutableLiveData()
    override val onNavigateBack = _onNavigateBack



    override fun navigateBack() {
        _onNavigateBack.value = Unit
    }
}