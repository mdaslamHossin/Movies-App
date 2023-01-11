package com.aslamhossin.movies.arch.system

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    protected var binding: VB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater.invoke(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    open fun init(savedInstanceState: Bundle?) {
        configureViews(savedInstanceState)
        bindWithViewModel()
        collectFlows()
    }

    open fun configureViews(savedInstanceState: Bundle?) {}

    open fun bindWithViewModel() {}

    open fun collectFlows() {}

    // ... Call this function at onAttach() function if want to override onBackPressed event
    protected fun handleBackPressEvent(backPressedEvent: () -> Unit) {
        val backPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                backPressedEvent()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressedCallback)
    }

}