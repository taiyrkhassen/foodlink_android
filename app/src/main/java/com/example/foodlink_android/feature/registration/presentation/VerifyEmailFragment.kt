package com.example.foodlink_android.feature.registration.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R

class VerifyEmailFragment: Fragment(){
    companion object {
        fun newInstance(data: Bundle? = null): VerifyEmailFragment {
            val fragment = VerifyEmailFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.code_access, container, false)
    }
}