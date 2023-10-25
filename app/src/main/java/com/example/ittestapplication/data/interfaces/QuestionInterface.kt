package com.example.ittestapplication.data.interfaces

import com.example.ittestapplication.data.model.ApiResponse
import com.example.ittestapplication.data.model.Question
import com.example.ittestapplication.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface QuestionInterface {
    @Headers("Content-Type:application/json")
    @GET("questions")
    fun getAllQuestions(): Call<ApiResponse<Question>>

    @Headers("Content-Type:application/json")
    @GET("questions/professions/{prof_id}")
    fun getQuestionsById(@Path("prof_id")prof_id:Int): Call<Question>
}