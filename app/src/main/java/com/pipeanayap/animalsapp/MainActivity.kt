package com.pipeanayap.animalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.pipeanayap.animalsapp.screens.AmbienteScreen
import com.pipeanayap.animalsapp.screens.HomeScreen
import com.pipeanayap.animalsapp.ui.theme.AnimalsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalsAppTheme {
                var selectedScreen by remember {
                    mutableStateOf("Inicio")
                }
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize().background(Color(0xff2c3a2f)),
                    contentColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    bottomBar = {
                        NavigationBar(
                            containerColor = Color(0xFFF4FB9C) ) {
                            NavigationBarItem(
                                selected = selectedScreen == "Inicio",
                                onClick = {
                                    selectedScreen = "Inicio"
                                    navController.navigate("Inicio")
                                },
                                icon = {
                                    Text(
                                        text = "Inicio",
                                        color = if (selectedScreen == "Inicio") Color.Black else Color.Gray
                                    )
                                }
                            )
                            NavigationBarItem(
                                selected = selectedScreen == "Ambientes",
                                onClick = {
                                    selectedScreen = "Ambientes"
                                    navController.navigate("Ambientes")
                                },
                                icon = {
                                    Text(
                                        text = "Ambientes",
                                        color = if (selectedScreen == "Ambientes") Color.Black else Color.Gray
                                    )
                                }
                            )
                        }
                    }



                )
                { innerPadding ->
                    NavHost(navController = navController, startDestination = "Inicio"){
                        composable(route = "Inicio"){
                            HomeScreen(innerPadding)
                        }
                        composable(route = "Ambientes"){
                            AmbienteScreen(innerPadding)
                        }
                    }

                }
            }
        }
    }
}


