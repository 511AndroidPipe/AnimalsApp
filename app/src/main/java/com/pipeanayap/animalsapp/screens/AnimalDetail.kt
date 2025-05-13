package com.pipeanayap.animalsapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.pipeanayap.animalsapp.AnimalsService
import com.pipeanayap.animalsapp.models.Animal
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import com.pipeanayap.animalsapp.R


@Composable
fun AnimalDetailScreen(
    innerPadding: PaddingValues,
    animalId: String,
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val baseUrl = "https://animals.juanfrausto.com/api/"
    var animal by remember { mutableStateOf<Animal?>(null) }
    var isLoading by remember { mutableStateOf(true) } // Estado de carga

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val animalService = retrofitBuilder.create(AnimalsService::class.java)
                val response = animalService.getAnimalById(animalId)
                animal = response
                isLoading = false // Datos cargados
                Log.i("ProductDetail", response.toString())
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
        animal?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(30.dp)
                    .padding(top = 30.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = it.name,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                AsyncImage(
                    model = it.image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = it.description,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    text = "Hechos \ninteresantes",
                    color = Color(0xFFFFD700), // Amarillo dorado
                    fontSize = 30.sp
                )

                it.facts.forEach { fact ->
                    Box(
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .clip(RoundedCornerShape(50)) // Borde redondeado
                            .background(Color.White.copy(alpha = .05f)) // Fondo gris oscuro
                            .padding(horizontal = 16.dp, vertical = 12.dp) // Espaciado interno
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = null,
                                tint = Color(0xFFE8FF8B) // Amarillo verdoso
                            )
                            Text(
                                text = fact,
                                color = Color.White,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Center,
                    text = "Galería de\n imágenes",
                    color = Color(0xFFFFD700), // Amarillo dorado
                    fontSize = 30.sp
                )

                it.imageGallery.forEach { image ->
                    AsyncImage(
                        model = image,
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),
                        error =  painterResource(R.drawable.no_image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop, // Recorta sin deformar
                        modifier = Modifier
                            .padding(top = 15.dp)
                            .fillMaxWidth()
                            .height(200.dp) // Altura fija para uniformidad
                            .clip(RoundedCornerShape(16.dp))
                    )
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
}
