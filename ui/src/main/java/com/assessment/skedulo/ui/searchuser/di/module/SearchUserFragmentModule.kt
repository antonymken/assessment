package com.assessment.skedulo.ui.searchuser.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assessment.skedulo.structuerandroid.di.annotation.ViewModelKey
import com.assessment.skedulo.structuerandroid.di.module.ViewModelFactory
import com.assessment.skedulo.ui.searchuser.SearchUserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * will be use to provide objects at activity level for main activity
 */
@Module
abstract class SearchUserFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchUserViewModel::class)
    abstract fun provideSearchUserViewModel(resultsViewModel: SearchUserViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}