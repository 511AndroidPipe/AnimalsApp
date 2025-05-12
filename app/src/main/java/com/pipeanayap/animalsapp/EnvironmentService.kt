package com.pipeanayap.animalsapp

import com.pipeanayap.animalsapp.models.Animal
import com.pipeanayap.animalsapp.models.Environment
import retrofit2.http.GET
import retrofit2.http.Path

interface EnvironmentService {

    @GET("environments")
    suspend fun getEnvironments(): List<Environment>

    @GET("environments/{id}")
    suspend fun getEnvironmentById(@Path("id") id: String): Environment


}