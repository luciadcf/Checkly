package com.luciadcf.checkly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luciadcf.checkly.feature.home.ui.navigation.HomeRoute
import com.luciadcf.checkly.feature.home.ui.home.HomeScreen
import com.luciadcf.checkly.ui.theme.ChecklyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChecklyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 1. Creamos el controlador de navegación
                    val navController = rememberNavController()

                    // 2. Definimos el NavHost (el contenedor de pantallas)
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute
                    ) {
                        // 3. Declaramos la pantalla de la Home
                        composable<HomeRoute> {
                            HomeScreen()
                        }

                        // Aquí añadirías más pantallas en el futuro:
                        // composable<SettingsRoute> { SettingsScreen() }
                    }
                }
            }
        }
    }
}