package com.example.mynews2.model

import com.google.gson.annotations.SerializedName
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
        tableName = "datamodel"
)

data class DataModel(
        @PrimaryKey(autoGenerate = true)
    @SerializedName("title")
    val title : String,

    @SerializedName("author")
    val author: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("sources")
    val source: String,

    @SerializedName("countries")
    val country: String,

    @SerializedName("published_at")
    val time: String

)
