package com.pipeanayap.animalsapp

import com.pipeanayap.animalsapp.models.Animal
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimalsService {

    @GET("animals")
    suspend fun getAnimals(): List<Animal>

    @GET("animals/{id}")
    suspend fun getAnimalById(@Path("id") id: String): Animal

    @GET("environments")
    suspend fun getEnvironments():
}
