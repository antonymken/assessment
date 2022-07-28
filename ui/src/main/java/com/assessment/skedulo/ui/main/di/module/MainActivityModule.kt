package com.assessment.skedulo.ui.main.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assessment.skedulo.structuerandroid.di.annotation.ViewModelKey
import com.assessment.skedulo.structuerandroid.di.module.ViewModelFactory
import com.assessment.skedulo.ui.main.MainViewModel
import com.assessment.skedulo.ui.main.SharedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * will be use to provide objects at activity level for main activity
 */
@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    abstract fun provideSharedViewModel(sharedViewModel: SharedViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}