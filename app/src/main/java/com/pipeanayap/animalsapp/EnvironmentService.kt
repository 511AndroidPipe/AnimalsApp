package com.pipeanayap.animalsapp

import com.pipeanayap.animalsapp.models.Environment
import retrofit2.http.GET

interface EnvironmentService {

    @GET("environments")
    suspend fun getEnvironments(): List<Environment>

}