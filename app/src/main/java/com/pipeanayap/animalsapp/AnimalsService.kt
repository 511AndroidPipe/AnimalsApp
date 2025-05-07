package com.pipeanayap.animalsapp

import com.pipeanayap.animalsapp.models.Animal
import retrofit2.http.GET

interface AnimalsService {

    @GET("animals")
    suspend fun getAnimals(): List<Animal>
}
