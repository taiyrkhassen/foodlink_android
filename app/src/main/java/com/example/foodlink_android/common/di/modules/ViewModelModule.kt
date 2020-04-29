package com.example.foodlink_android.common.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodlink_android.SplashViewModel
import com.example.foodlink_android.common.di.viewModelFactory.ViewModelFactory
import com.example.foodlink_android.common.di.viewModelFactory.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

//Это то чем потом мы будем анонсировать модели в модуле:
@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun mainViewModel(viewModel: SplashViewModel): ViewModel

}