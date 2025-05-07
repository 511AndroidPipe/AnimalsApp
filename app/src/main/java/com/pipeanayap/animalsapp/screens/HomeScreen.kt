package com.pipeanayap.animalsapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import com.pipeanayap.animalsapp.AnimalsService
import com.pipeanayap.animalsapp.PlanetService
import com.pipeanayap.animalsapp.models.Animal
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun HomeScreen(paddingValues: PaddingValues) {
    var animal by remember {
        mutableStateOf(emptyList<Animal>()) // Inicialización correcta
    }

    val scope = rememberCoroutineScope()
    val baseUrl = "https://animals.juanfrausto.com/api/"

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val animalService = retrofit.create(AnimalsService::class.java)
                animal = animalService.getAnimals()
                Log.i("HomeScreen",animal.toString())
            } catch (e: Exception) {
                Log.e("HomeScreen", "Error: ${e.message}")
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "Animales",
                color = Color.White
            )
            Button(
                onClick = {}
            ) {
                Text(
                    text = "Agregar"
                )
            }
        }

    }
}