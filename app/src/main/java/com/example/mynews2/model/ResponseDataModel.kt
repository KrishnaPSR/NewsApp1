package com.example.mynews2.model

import com.example.mynews2.model.DataModel
import com.google.gson.annotations.SerializedName

data class ResponseDataModel(
    @SerializedName("data")
    val data: ArrayList<DataModel>
)
