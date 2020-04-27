package com.example.foodlink_android.di.components

import com.example.foodlink_android.api.ApiService
import com.example.foodlink_android.di.modules.RepositoryModules
import com.example.foodlink_android.di.modules.ServiceModule
import com.example.foodlink_android.di.modules.ViewModelModule
import dagger.Component

@Component(modules = [ServiceModule::class, RepositoryModules::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface ServiceComponent {
    fun getApiService(): ApiService
}