package com.example.casehub.main

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.casehub.R
import com.example.casehub.databinding.ActivityMainBinding
import com.example.network.ConnectivityObserver
import com.example.network.NetworkConnectivityObserver
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    //Необходимые данные для проверки интернета
    private lateinit var networkBlank: ConstraintLayout
    private lateinit var connectivityObserver: ConnectivityObserver

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

           networkBlank = findViewById(R.id.network_include)
                connectivityObserver = NetworkConnectivityObserver(applicationContext)
        val bottomNavBar = binding.bottomNavigationMain
        val navController = findNavController(R.id.navHostFragment)
        bottomNavBar.setupWithNavController(navController)

        val toolbar = binding.toolbarMain
        setSupportActionBar(toolbar)

        val appBarConfiguration = AppBarConfiguration (
            setOf(R.id.mainFragment, R.id.workshopFragment, R.id.profileFragment)
        )

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        window.insetsController?.let {
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            it.hide(WindowInsets.Type.systemBars())
        }

        //Проверка интернета после запуска
        val currentStatus =  (connectivityObserver as NetworkConnectivityObserver)  .getCurrentStatus()
        networkBlank.visibility = if(currentStatus == ConnectivityObserver.Status.Available){
            ConstraintLayout.GONE
        }
        else{
            ConstraintLayout.VISIBLE
        }

        //Ассинхронная проверка интернета
        lifecycleScope.launch {
            connectivityObserver.observe().collect { status ->
                when(status){
                    ConnectivityObserver.Status.Available -> {
                        networkBlank.visibility = ConstraintLayout.GONE
                    }
                    else -> {
                        networkBlank.visibility = ConstraintLayout.VISIBLE
                    }
                }

            }
        }

        TODO("Пофикси возможность свапа темы и взаимодействие с поисковиком в случае потери интернета.");


//        binding.bottomNavigationBar.setOnApplyWindowInsetsListener(null)
//        binding.bottomNavigationBar.setPadding(0,0,0,0)

    }
}


