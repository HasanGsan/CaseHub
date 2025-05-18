package com.hasyanapp.casehub.main

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController

import com.hasyanapp.casehub.R
import com.hasyanapp.casehub.databinding.ActivityMainBinding
import com.hasyanapp.casehub.core.network.ConnectivityObserver
import com.hasyanapp.casehub.core.network.NetworkConnectivityObserver
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val bottomNavBar = binding.bottomNavigationMain
        val navController = findNavController(R.id.navHostFragment)
        bottomNavBar.setupWithNavController(navController)

        //Toolbar / Appbar
        val toolbar = binding.toolbarMain
        setSupportActionBar(toolbar)

        val appBarConfiguration = AppBarConfiguration (
            setOf(R.id.mainFragment, R.id.workshopFragment, R.id.profileFragment)
        )

        // Навигация
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        window.insetsController?.let {
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            it.hide(WindowInsets.Type.systemBars())
        }

    }
}