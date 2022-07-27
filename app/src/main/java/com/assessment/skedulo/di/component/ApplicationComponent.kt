package com.assessment.skedulo.di.component

import com.assessment.skedulo.AssessmentApplication
import com.assessment.skedulo.di.module.ActivityBindingModule
import com.assessment.skedulo.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        (ApplicationModule::class),
        (AndroidInjectionModule::class),
        (ActivityBindingModule::class)
    ]
)
interface ApplicationComponent : AndroidInjector<AssessmentApplication> {

    override fun inject(application: AssessmentApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AssessmentApplication): Builder

        fun build(): ApplicationComponent
    }
}