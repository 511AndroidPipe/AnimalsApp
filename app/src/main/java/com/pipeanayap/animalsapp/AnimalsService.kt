package com.pipeanayap.animalsapp

import com.pipeanayap.animalsapp.models.Animal
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimalsService {

    @GET("animals")
    suspend fun getAnimals(): List<Animal>

    @GET("animals/{id}")
    suspend fun getAnimalById(@Path("id") id: String): Animal

    @GET("animals")
    suspend fun getAnimalsByEnvironment(@Query("environmentId") environmentId: String): List<Animal>

}
