package com.assessment.skedulo.structuerandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory @Inject constructor(
    private val providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) :ViewModelProvider.Factory {

    @SuppressWarnings("unchecked")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return (providerMap[modelClass] ?: error("ViewModelProvider null key")).get() as T
    }

}