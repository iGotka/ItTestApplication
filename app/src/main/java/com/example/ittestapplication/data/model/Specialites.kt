package com.example.ittestapplication.data.model

import com.google.gson.annotations.SerializedName

data class Specialites(
    @SerializedName("code_specialization" ) var codeSpecialization : String? = null,
    @SerializedName("id_department"       ) var idDepartment       : Int?    = null,
    @SerializedName("info_specialization" ) var infoSpecialization : String? = null,
    @SerializedName("specialization"      ) var specialization     : String? = null,
    @SerializedName("specialtie_id"       ) var specialtieId       : Int?    = null
)