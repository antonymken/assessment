package com.assessment.skedulo.di.module

import android.content.Context
import com.assessment.skedulo.TestAssessmentApplication
import dagger.Binds
import dagger.Module

@Module
abstract class TestApplicationModule {

    @Binds
    internal abstract fun bindContext(application: TestAssessmentApplication): Context

}