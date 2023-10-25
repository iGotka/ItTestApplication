package com.example.ittestapplication.data.interfaces


import com.example.ittestapplication.data.model.ApiResponse
import com.example.ittestapplication.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface UserInterface {
    @Headers("Content-Type:application/json")
    @GET("profile_users/")
    fun getUser(@Query("login")login:String): Call<User>

    @Headers("Content-Type:application/json")
    @GET("profile_users/")
    fun getAuth(
        @Query("login")login:String,
        @Query("password")password:String
    ): Call<ApiResponse<User>>

    @Headers("Content-Type:application/json")
    @POST("profile_users/")
    fun createUser(
        @Query("login")login:String,
        @Query("password")password:String,
        @Query("first_name")firstName:String,
        @Query("last_name")lastName:String,
        @Query("middle_name")middleName:String
    ): Call<ApiResponse<User>>
}