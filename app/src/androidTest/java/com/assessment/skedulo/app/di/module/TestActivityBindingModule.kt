package com.assessment.skedulo.app.di.module

import com.assessment.skedulo.ui.main.MainActivity
import com.assessment.skedulo.ui.main.di.module.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class TestActivityBindingModule {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    internal abstract fun mainActivity(): MainActivity

}