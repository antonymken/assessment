package com.assessment.skedulo.structuerandroid.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import com.assessment.skedulo.structuer.presenter.Presenter
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.assessment.skedulo.structuerandroid.PresenterViewModel
import com.assessment.skedulo.structuerandroid.di.module.ViewModelFactory
import javax.inject.Inject


abstract class ViewModelActivity<V, VM, P, B>(@LayoutRes private val layoutId: Int) : BaseActivity()
        where   VM : PresenterViewModel<V, P>, P : Presenter<V>, B : ViewDataBinding {

    lateinit var viewModel: VM
    lateinit var sharedViewModel: ViewModel
    lateinit var binding: B

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        buildViewModel()
        binding = DataBindingUtil.setContentView(this, layoutId)
        bindViewModel()
        (viewModel as PresenterViewModel<V, P>).onCreate()
        observeLiveData()
    }

    abstract fun bindViewModel()

    abstract fun buildViewModel()

    abstract fun observeLiveData()
}