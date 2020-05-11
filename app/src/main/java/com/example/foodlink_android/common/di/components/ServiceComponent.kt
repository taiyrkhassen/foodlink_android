package com.example.foodlink_android.common.di.components

import com.example.foodlink_android.SplashActivity
import com.example.foodlink_android.common.api.ApiService
import com.example.foodlink_android.common.base.BaseActivity
import com.example.foodlink_android.common.di.modules.RepositoryModules
import com.example.foodlink_android.common.di.modules.ServiceModule
import com.example.foodlink_android.common.di.modules.ViewModelModule
import dagger.Component

@Component(modules = [ServiceModule::class, RepositoryModules::class, ViewModelModule::class], dependencies = [AppComponent::class])
interface ServiceComponent {
    fun getApiService(): ApiService
    fun inject(activity: SplashActivity)
}