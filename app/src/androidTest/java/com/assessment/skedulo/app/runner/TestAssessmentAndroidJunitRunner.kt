package com.assessment.skedulo.app.runner

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.assessment.skedulo.TestAssessmentApplication


class TestAssessmentAndroidJunitRunner : AndroidJUnitRunner() {

    @Throws(InstantiationException::class, IllegalAccessException::class, ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return Instrumentation.newApplication(TestAssessmentApplication::class.java, context)
    }
}