package com.pipeanayap.animalsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.balltrajectory.Teleport
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable
import com.pipeanayap.animalsapp.screens.AmbienteScreen
import com.pipeanayap.animalsapp.screens.AnimalDetailScreen
import com.pipeanayap.animalsapp.screens.EnvironmentDetailScreen
import com.pipeanayap.animalsapp.screens.HomeScreen
import com.pipeanayap.animalsapp.ui.theme.AnimalsAppTheme
import com.pipeanayap.animalsapp.utils.Lion
import com.pipeanayap.animalsapp.utils.Tree

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimalsAppTheme {
                val navController = rememberNavController()
                var selectedScreen by remember { mutableStateOf(0) }

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff2c3a2f))
                ) {
                    Scaffold(
                        contentWindowInsets = WindowInsets(0.dp),
                        containerColor = Color.Transparent,
                        contentColor = Color.Transparent,
                    ) { innerPadding ->
                        NavHost(navController = navController, startDestination = "Inicio") {
                            composable("Inicio") {
                                HomeScreen(innerPadding, navController)
                            }
                            composable("Ambientes") {
                                AmbienteScreen(innerPadding, navController)
                            }
                            composable("animal-detail/{id}", arguments = listOf(
                                navArgument("id") { type = NavType.StringType }
                            )) {
                                val animalId = it.arguments?.getString("id") ?: ""
                                AnimalDetailScreen(innerPadding, animalId, navController)
                            }
                            composable("environment-detail/{id}", arguments = listOf(
                                navArgument("id") { type = NavType.StringType }
                            )) {
                                val envId = it.arguments?.getString("id") ?: ""
                                EnvironmentDetailScreen(innerPadding, envId, navController)
                            }
                        }
                    }

                    // Barra flotante encima del contenido
                    AnimatedNavigationBar(
                        selectedIndex = selectedScreen,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 40.dp, start = 60.dp, end = 60.dp)
                            .shadow(elevation = 12.dp, shape = RoundedCornerShape(24.dp), clip = true),
                        barColor = Color(0xFFF4FB9C),
                        ballColor = Color(0xFF4CAF50),
                        ballAnimation = Parabolic(tween(300)),
                        indentAnimation = Height(tween(300)),
                        cornerRadius = shapeCornerRadius(24.dp)
                    ) {
                        // Item 1: Inicio
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .noRippleClickable {
                                    selectedScreen = 0
                                    navController.navigate("Inicio")
                                }
                                .padding(12.dp)
                        ) {
                            Icon(
                                imageVector = Lion,
                                contentDescription = "Inicio",
                                tint = if (selectedScreen == 0) Color.Black else Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Inicio",
                                color = if (selectedScreen == 0) Color.Black else Color.Gray,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }

                        // Item 2: Ambientes
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .noRippleClickable {
                                    selectedScreen = 1
                                    navController.navigate("Ambientes")
                                }
                                .padding(12.dp)
                        ) {
                            Icon(
                                imageVector = Tree,
                                contentDescription = "Ambientes",
                                tint = if (selectedScreen == 1) Color.Black else Color.Gray,
                                modifier = Modifier.size(20.dp)
                            )
                            Text(
                                text = "Ambientes",
                                color = if (selectedScreen == 1) Color.Black else Color.Gray,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }

                }
            }
        }

    }
}


