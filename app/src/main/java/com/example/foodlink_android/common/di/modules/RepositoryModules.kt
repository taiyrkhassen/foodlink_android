package com.example.foodlink_android.common.di.modules

import android.content.SharedPreferences
import com.example.foodlink_android.common.api.ApiService
import com.example.foodlink_android.repositories.RepositoryAuthImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModules {
    @Provides
    fun provideMainRepository(apiService: ApiService, sharedPreferences: SharedPreferences): RepositoryAuthImpl {
        return RepositoryAuthImpl(apiService, sharedPreferences)
    }

}

