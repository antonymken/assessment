package com.assessment.skedulo

import com.assessment.skedulo.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.Dispatchers

/**
 * **  custom application class, used to build the dagger application component
 */
open class AssessmentApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out AssessmentApplication> {
        return DaggerApplicationComponent.builder().application(this).coroutineContext(Dispatchers.IO).build()
    }
}