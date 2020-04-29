package com.example.foodlink_android

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.foodlink_android.common.base.BaseActivity
import com.example.foodlink_android.common.constants.ApplicationConstants.TAB
import com.example.foodlink_android.common.di.components.DaggerServiceComponent
import com.example.foodlink_android.feature.CommonMainActivity
import com.example.foodlink_android.feature.registration.presentation.RegistrationActivityContainer
import org.jetbrains.anko.toast
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    init {
        DaggerServiceComponent.builder()
            .appComponent(FoodLinkApp.appComponent)
            .build()
            .inject(this)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed({
            checkFirstIn()
            viewModel.stateLiveData.observe(this, Observer { result ->
                when (result) {
                    is SplashViewModel.State.Result -> {
                        if (result.isFirstTime) {
                            RegistrationActivityContainer.start(this)
                            finish()
                            overridePendingTransition(0, 0)
                        } else {
                            CommonMainActivity.start(this, page = TAB to 4)
                            finish()
                            overridePendingTransition(0, 0)
                        }
                    }
                    is SplashViewModel.State.Error -> {
                        toast(result.messageError)
                    }
                }
            })
        }, 2000)

    }

    private fun checkFirstIn() {
        viewModel.checkAuth()
    }
}