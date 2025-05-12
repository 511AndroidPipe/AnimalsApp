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
import com.pipeanayap.animalsapp.EnvironmentService
import com.pipeanayap.animalsapp.components.AnimalComponent
import com.pipeanayap.animalsapp.components.EnvironmentComponent
import com.pipeanayap.animalsapp.models.Animal
import com.pipeanayap.animalsapp.models.Environment
import com.pipeanayap.animalsapp.ui.theme.AnimalsAppTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AmbienteScreen(paddingValues: PaddingValues, navController: NavController){

    var environment by remember {
        mutableStateOf(emptyList<Environment>())
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
                val environmentService = retrofit.create(EnvironmentService::class.java)
                environment = environmentService.getEnvironments()
                Log.i("EnvironmentScreen", environment.toString())
            } catch (e: Exception) {
                Log.e("HomeScreen", "Error: ${e.message}")
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Ambientes",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Column {
            environment.forEach{ environment ->
                EnvironmentComponent(
                    environment = environment,
                    onClick = {selectedEnvironment ->
                        navController.navigate("environment-detail/${selectedEnvironment.id}")
                    })

            }
        }
    }
}