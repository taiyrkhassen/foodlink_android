package com.example.foodlink_android

import android.app.Activity
import android.app.Application
import com.example.foodlink_android.di.components.AppComponent
import com.example.foodlink_android.di.components.ServiceComponent
import com.example.foodlink_android.di.modules.AppModule

class FoodLinkApp : Application(){
    companion object {

        fun get(activity: Activity): FoodLinkApp {
            return activity.application as FoodLinkApp
        }

        lateinit var appComponent: AppComponent
        lateinit var serviceComponent: ServiceComponent

        fun getApplicationComponent(): AppComponent {
            return appComponent
        }

    }

    override fun onCreate() {
        super.onCreate()
//        createAppComponent()
//        createServiceComponent()
    }

//    private fun createAppComponent() {
//        appComponent = DaggerAppComponent
//            .builder()
//            .appModule(AppModule(this, BASE_URL))
//            .build()
//    }
//
//    private fun createServiceComponent() {
//        serviceComponent = DaggerServiceComponent
//            .builder()
//            .appComponent(appComponent)
//            .build()
//    }
}