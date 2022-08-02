package com.assessment.skedulo

import com.assessment.skedulo.di.component.DaggerTestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.Dispatchers

/**
 * **  custom application class, used to build the dagger application component
 */
class TestAssessmentApplication : AssessmentApplication() {
    lateinit var component: AndroidInjector<out TestAssessmentApplication>

    override fun applicationInjector(): AndroidInjector<out TestAssessmentApplication> {
        component = DaggerTestApplicationComponent.builder().application(this).coroutineContext(Dispatchers.IO).build()
        return component
    }

    fun getApplicationComponent() = component
}