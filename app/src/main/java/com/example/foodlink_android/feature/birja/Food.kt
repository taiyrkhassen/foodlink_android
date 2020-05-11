package com.example.foodlink_android.feature.birja


import com.google.gson.annotations.SerializedName

data class Food(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("portion")
    val portion: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("products")
    val products: String,
    @SerializedName("time_of_cooking")
    val timeOfCooking: String
)