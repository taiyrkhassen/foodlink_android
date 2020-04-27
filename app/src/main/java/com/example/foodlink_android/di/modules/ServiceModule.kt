package com.example.foodlink_android.di.modules

import com.example.foodlink_android.api.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ServiceModule {
    @Provides
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}