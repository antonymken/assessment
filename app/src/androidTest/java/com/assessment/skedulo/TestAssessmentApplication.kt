package com.assessment.skedulo

import com.assessment.skedulo.app.di.component.DaggerTestApplicationComponent
import dagger.android.AndroidInjector

/**
 * **  custom application class, used to build the dagger application component
 */
class TestAssessmentApplication : AssessmentApplication() {
    lateinit var component: AndroidInjector<out TestAssessmentApplication>

    override fun applicationInjector(): AndroidInjector<out TestAssessmentApplication> {
        component = DaggerTestApplicationComponent.builder().application(this).build()
        return component
    }

    fun getApplicationComponent() = component
}