package com.example.foodlink_android.feature.profile

import android.os.Bundle
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(){
    companion object {
        fun newInstance(data: Bundle? = null): ProfileFragment {
            val fragment = ProfileFragment()
            fragment.arguments = data
            return fragment
        }
    }
}