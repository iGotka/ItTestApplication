package com.example.ittestapplication.data.interfaces

import com.example.ittestapplication.data.model.ApiResponse
import com.example.ittestapplication.data.model.Professions
import com.example.ittestapplication.data.model.Specialites
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfessionsInterface {
    @Headers("Content-Type:application/json")
    @GET("professions/")
    fun getProfessions(@Query("prof_name")prof_name:String): Call<Professions>

    @GET("professions/{id}")
    suspend fun getProfessionsById(@Path("id") id: Int): Professions?

    @Headers("Content-Type:application/json")
    @GET("professions/")
    fun getProfessions(
        @Query("prof_name")profName:String,
        @Query("prof_description")profDescription:String
    ): Call<ApiResponse<Professions>>

    @Headers("Content-Type:application/json")
    @POST("professions/")
    fun createProfessions(
        @Query("prof_name")profName:String,
        @Query("prof_description")profDescription:String
    ): Call<ApiResponse<Professions>>
}