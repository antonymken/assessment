package com.assessment.skedulo.di.module

import com.assessment.skedulo.ui.main.MainActivity
import com.assessment.skedulo.ui.main.di.module.MainActivityModule
import com.assessment.skedulo.ui.searchuser.SearchUserFragment
import com.assessment.skedulo.ui.searchuser.di.module.SearchUserFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class TestActivityBindingModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [(MainActivityModule::class), (SearchUserFragmentModule::class)]
    )
    internal abstract fun provideSearchUserFragment(): SearchUserFragment

}