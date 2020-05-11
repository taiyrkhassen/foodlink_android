package com.example.foodlink_android.feature.birja


import com.example.foodlink_android.feature.chefs.ChefData
import com.google.gson.annotations.SerializedName

data class BirjaData(
    @SerializedName("chef")
    val chef: List<ChefData>,
    @SerializedName("foods")
    val foods: List<Food>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("time")
    val time: String
)