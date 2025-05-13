package com.pipeanayap.animalsapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pipeanayap.animalsapp.AnimalsService
import com.pipeanayap.animalsapp.components.AnimalComponent
import com.pipeanayap.animalsapp.models.Animal
import com.pipeanayap.animalsapp.ui.theme.AnimalsAppTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun HomeScreen(paddingValues: PaddingValues, navController: NavController) {
    var animal by remember {
        mutableStateOf(emptyList<Animal>())
    }

    val scope = rememberCoroutineScope()
    val baseUrl = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val animalService = retrofit.create(AnimalsService::class.java)
                animal = animalService.getAnimals()
                Log.i("HomeScreen", animal.toString())
            } catch (e: Exception) {
                Log.e("HomeScreen", "Error: ${e.message}")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(top = 50.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título y botón
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),

            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Animales",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(horizontal = 30.dp))

            Button(
                onClick = { /* TODO */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF4FB9C),
                    contentColor = Color.Black
                )
            ) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.Black)
                Text(modifier = Modifier.padding(start = 5.dp), text =  "Agregar")
            }
        }

        // Texto centrado
        Text(
            text = "Conoce a los animales más increíbles\ndel mundo",
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 12.dp)
        )

        // (Aquí podrías seguir con más contenido si lo deseas)

        Column {
             animal.forEach{ animal ->
                 AnimalComponent(
                    animal = animal,
                     onClick = {selectedAnimal ->
                         navController.navigate("animal-detail/${selectedAnimal.id}")
                     })

                }
             }

        Spacer(modifier = Modifier.padding(vertical = 40.dp))
        }

    }



