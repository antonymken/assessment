package com.assessment.skedulo.di.module

import android.content.Context
import com.assessment.skedulo.AssessmentApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    internal abstract fun bindContext(application: AssessmentApplication): Context

}