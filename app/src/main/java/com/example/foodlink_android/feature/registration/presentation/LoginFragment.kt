package com.example.foodlink_android.feature.registration.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment

class LoginFragment: Fragment() {

    companion object {
        fun newInstance(data: Bundle? = null): LoginFragment {
            val fragment = LoginFragment()
            fragment.arguments = data
            return fragment
        }
    }
}