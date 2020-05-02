package com.example.foodlink_android.feature.profile

import android.graphics.Bitmap

data class FoodData(
    val image: Bitmap,
    val nameFood: String,
    val dataOrder: String,
    val timeOrder: String
)