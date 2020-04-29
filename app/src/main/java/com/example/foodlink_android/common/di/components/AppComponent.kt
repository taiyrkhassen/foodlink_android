package com.example.foodlink_android.common.di.components

import android.content.Context
import android.content.SharedPreferences
import com.example.foodlink_android.common.di.modules.AppModule
import com.example.foodlink_android.common.di.modules.NetworkModule
import com.example.foodlink_android.common.di.modules.RepositoryModules
import com.example.foodlink_android.common.di.modules.ViewModelModule
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModules::class, ViewModelModule::class])
interface AppComponent {
    fun getContext(): Context
    fun getRetrofit(): Retrofit
    fun getPrefs(): SharedPreferences
}