package com.example.foodlink_android.feature.status_order

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatusOrder(
    val price: Int,
    val descriptionOrder: String,
    val imageBig:String? = null,
    val time:String,
    val imageChef:String? = null,
    val status:Int
): Parcelable