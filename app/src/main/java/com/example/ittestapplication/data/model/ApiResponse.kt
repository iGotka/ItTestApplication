package com.example.ittestapplication.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("data" ) var data : List<T>,
    @SerializedName("success"  ) var success : Boolean? = null,
)
