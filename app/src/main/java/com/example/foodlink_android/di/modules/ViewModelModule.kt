package com.example.foodlink_android.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.foodlink_android.di.viewModelFactory.ViewModelFactory
import dagger.Binds
import dagger.Module

//Это то чем потом мы будем анонсировать модели в модуле:
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}