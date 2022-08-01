package com.assessment.skedulo.structure

import android.Manifest
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.rule.GrantPermissionRule
import androidx.test.runner.AndroidJUnit4
import com.assessment.skedulo.TestAssessmentApplication
import com.assessment.skedulo.app.di.component.TestApplicationComponent
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * **  Created by antonyn on 1/01/2018.
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
abstract class BaseScreenTest {

    @Rule
    @JvmField
    var runtimePermissionRule = GrantPermissionRule.grant(
        Manifest.permission.INTERNET
    )!!

    @get:Rule
    val composeTestRule = createComposeRule()

    @Throws(Throwable::class)
    @Before
    fun setUp() {

        val instrumentation = getInstrumentation()
        val testApp = instrumentation.targetContext.applicationContext as TestAssessmentApplication
        val component = testApp.getApplicationComponent() as TestApplicationComponent

        component.inject(this)

    }

}