package com.example.foodlink_android.feature.birja

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R

class BirjaFragment :Fragment(){

    companion object {
        fun newInstance(data: Bundle? = null): BirjaFragment {
            val fragment = BirjaFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.birja_fragment, container, false)
    }
}