package com.assessment.skedulo.structuerandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.google.accompanist.appcompattheme.AppCompatTheme
import com.assessment.skedulo.structuer.presenter.Presenter
import com.assessment.skedulo.structuerandroid.PresenterViewModel
import com.assessment.skedulo.structuerandroid.di.module.ViewModelFactory
import javax.inject.Inject


abstract class ViewModelFragment<V, VM, P> : BaseFragment()
        where   VM : PresenterViewModel<V, P>, P : Presenter<V> {

    lateinit var viewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        buildViewModel()
        (viewModel as PresenterViewModel<V, P>).onCreate()
        //return binding.root
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            (ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AppCompatTheme {
                    SetLayout()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    abstract fun buildViewModel()

    abstract fun init()

    @Composable
    abstract fun SetLayout()
}