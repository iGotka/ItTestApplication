package com.example.ittestapplication.data.interfaces

import com.example.ittestapplication.data.model.Specialites
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSpecialitesInterface {
    @GET("specialites")
    suspend fun getSpecialites(): List<Specialites>
    @GET("specialites/{id}")
    suspend fun getSpecialitesById(@Path("id") id: Int): Specialites?

    @POST("specialites")
    suspend fun createSpecialites(@Body body: JsonObject): Response<JsonObject>
}