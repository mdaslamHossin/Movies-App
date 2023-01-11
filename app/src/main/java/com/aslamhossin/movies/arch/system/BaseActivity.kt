package com.aslamhossin.movies.arch.system

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding>(
    val bindingInflater: (LayoutInflater) -> VB
) : AppCompatActivity() {

    protected var binding: VB? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingInflater(layoutInflater)
        setContentView(binding?.root)

        init(savedInstanceState)
    }

    open fun init(savedInstanceState: Bundle?) {
        configureViews()
        bindWithViewModel()
        collectFlows()
    }

    open fun configureViews() {}

    open fun bindWithViewModel() {}

    open fun collectFlows() {}

}