package com.assessment.skedulo.structuerandroid.fragment


import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import dagger.android.support.DaggerFragment

/**
 * **  Base fragment sets up dagger injection
 */
abstract class BaseFragment : DaggerFragment(){
    @Composable
    abstract fun SetLayout()

    abstract fun init()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}