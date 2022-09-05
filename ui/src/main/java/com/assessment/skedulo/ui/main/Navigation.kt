package com.assessment.skedulo.ui.main

import androidx.lifecycle.LiveData


interface Navigation {
    fun navigateBack()
    val onNavigateBack: LiveData<Unit?>
}