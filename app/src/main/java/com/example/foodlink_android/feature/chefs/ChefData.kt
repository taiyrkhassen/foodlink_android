package com.example.foodlink_android.feature.chefs

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChefData(
    val chef_image: String? = null,
    val chef_name: String,
    val chef_description: String,
    val chef_rating: Float,
    val number_order: Int
) : Parcelable