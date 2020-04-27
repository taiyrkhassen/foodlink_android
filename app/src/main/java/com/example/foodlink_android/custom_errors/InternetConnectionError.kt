package com.example.foodlink_android.custom_errors

import com.example.foodlink_android.FoodLinkApp
import com.example.foodlink_android.R
import java.io.IOException

class NoConnectivityException : IOException() {
    val context = FoodLinkApp.getApplicationComponent().getContext()
    override val message: String
        get() =
            context.getString(R.string.no_network_available)
}

class NoInternetException() : IOException() {
    val context = FoodLinkApp.getApplicationComponent().getContext()
    override val message: String
        get() =
            context.getString(R.string.check_connected_wifi)
}
