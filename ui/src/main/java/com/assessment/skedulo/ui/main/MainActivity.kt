package com.assessment.skedulo.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.assessment.skedulo.R
import com.assessment.skedulo.databinding.ActivityMainLayoutBinding
import com.assessment.skedulo.domain.main.MainPresenter
import com.assessment.skedulo.domain.main.MainView
import com.assessment.skedulo.structuerandroid.activity.ViewModelActivity


class MainActivity :
    ViewModelActivity<MainView, MainViewModel, MainPresenter, ActivityMainLayoutBinding>
        (R.layout.activity_main_layout) {

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun buildViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        sharedViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(SharedViewModel::class.java)
    }

    override fun bindViewModel() {
        binding.viewModel = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.setGraph(R.navigation.nav_graph)
    }

    override fun observeLiveData() {
        (sharedViewModel as Navigation).onNavigateBack.observe(this, {
            navController.navigateUp()
        })
    }

}