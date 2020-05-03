package com.example.foodlink_android.feature.profile

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FoodData(
    val image: String?=null,
    val nameFood: String,
    val dataOrder: String,
    val timeOrder: String
): Parcelable{

}