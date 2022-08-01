package com.assessment.skedulo.ui

import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@Suppress("MemberVisibilityCanPrivate", "FunctionName")
@RunWith(MockitoJUnitRunner::class)
abstract class BaseUnitTest {

    lateinit var application: Application
    protected val dispatcher = TestCoroutineDispatcher()

    private fun setTestContext() {
        application = Mockito.mock(Application::class.java)
    }

    abstract fun testSetup()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        setTestContext()
        Dispatchers.setMain(dispatcher)
        testSetup()
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
