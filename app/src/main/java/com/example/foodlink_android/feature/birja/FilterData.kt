package com.example.foodlink_android.feature.birja

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FilterData(
    val id:Int,
    val filerName: String
):Parcelable