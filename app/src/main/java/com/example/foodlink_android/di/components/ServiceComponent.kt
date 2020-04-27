package com.example.foodlink_android.di.components

import com.example.foodlink_android.di.modules.ViewModelModule
import dagger.Component

@Component(modules = [ViewModelModule::class], dependencies = [AppComponent::class])
interface ServiceComponent {


}