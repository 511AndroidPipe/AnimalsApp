package com.pipeanayap.animalsapp.screens

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.pipeanayap.animalsapp.AnimalsService
import com.pipeanayap.animalsapp.EnvironmentService
import com.pipeanayap.animalsapp.components.AnimalComponent
import com.pipeanayap.animalsapp.models.Animal
import com.pipeanayap.animalsapp.models.Environment
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun EnvironmentDetailScreen(
    innerPadding: PaddingValues,
    environmentId: String,
    navController: NavController
) {

    val scope = rememberCoroutineScope()
    val baseUrl = "https://animals.juanfrausto.com/api/"
    var environment by remember { mutableStateOf<Environment?>(null) }
    var animals by remember { mutableStateOf(emptyList<Animal>()) }
    var isLoading by remember { mutableStateOf(true) } // Estado de carga

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val environmentService = retrofitBuilder.create(EnvironmentService::class.java)
                val animalsService = retrofitBuilder.create(AnimalsService::class.java)

                //obtenemos ambiente
                val response = environmentService.getEnvironmentById(environmentId)
                environment = response

                //obtenemos animales
                val animalResponse = animalsService.getAnimalsByEnvironment(environmentId)
                animals = animalResponse

                isLoading = false // Datos cargados
                Log.i("EnvironmentDetailit ", response.toString())
            } catch (e: Exception) {
                Log.e("Error", "Error al cargar los datos: ${e.message}")
            }
        }

    }

    if (isLoading) {
        // Mostrar indicador de carga mientras se obtiene la información del producto
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // Mostrar la información del producto
        environment?.let { environment ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(30.dp)
                    .padding(top = 30.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    model = environment.image,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth, // Ajusta la imagen al tamaño definido
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clip(RoundedCornerShape(16.dp)) // Bordes redondeados
                )
                Text(
                    text = environment.name,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = environment.description,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 20.dp)
                )

                animals.let { animals ->
                    if (animals.isNotEmpty()) {
                        Column {
                            animals.forEach { animal ->
                                AnimalComponent(
                                    animal = animal,
                                    onClick = { selectedAnimal ->
                                        navController.navigate("animal-detail/${selectedAnimal.id}")
                                    }
                                )
                            }
                        }
                    }
                }

            }
        }
    } ?: run {
        // Manejar el caso en que no se encuentra el producto
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Producto no encontrado", color = Color.White)
        }
    }
}

