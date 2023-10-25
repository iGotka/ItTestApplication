package com.example.ittestapplication.data.model

import com.google.gson.annotations.SerializedName


data class Professions(
    @SerializedName("prof_id" ) var profId : Int? = null,
    @SerializedName("prof_name"       ) var profName       : String?    = null,
    @SerializedName("prof_description" ) var profDescription : String? = null,
)
