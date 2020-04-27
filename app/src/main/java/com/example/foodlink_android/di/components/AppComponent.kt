package com.example.foodlink_android.di.components

import android.content.Context
import android.content.SharedPreferences
import com.example.foodlink_android.di.modules.AppModule
import com.example.foodlink_android.di.modules.NetworkModule
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun getContext(): Context
    fun getRetrofit(): Retrofit
    fun getPrefs(): SharedPreferences
}