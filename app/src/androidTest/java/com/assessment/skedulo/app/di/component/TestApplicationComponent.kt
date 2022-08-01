package com.assessment.skedulo.app.di.component

import com.assessment.skedulo.TestAssessmentApplication
import com.assessment.skedulo.data.di.module.DataModule
import com.assessment.skedulo.app.di.module.TestActivityBindingModule
import com.assessment.skedulo.app.di.module.TestApplicationModule
import com.assessment.skedulo.structure.BaseScreenTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (TestApplicationModule::class),
        (AndroidInjectionModule::class),
        (TestActivityBindingModule::class),
        (DataModule::class)
    ]
)
interface TestApplicationComponent : AndroidInjector<TestAssessmentApplication>  {

    override fun inject(application: TestAssessmentApplication)

    fun inject(test: BaseScreenTest)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TestAssessmentApplication): Builder

        fun build(): TestApplicationComponent
    }
}