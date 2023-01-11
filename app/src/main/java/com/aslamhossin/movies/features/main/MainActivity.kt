package com.aslamhossin.movies.features.main

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aslamhossin.movies.R
import com.aslamhossin.movies.arch.system.BaseActivity
import com.aslamhossin.movies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private lateinit var navController: NavController

    override fun configureViews() {
        configureBottomNavWithNavController()
    }

    private fun configureBottomNavWithNavController() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment

        navController = navHostFragment.navController
    }
}
