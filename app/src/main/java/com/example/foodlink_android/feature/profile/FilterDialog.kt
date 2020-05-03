package com.example.foodlink_android.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodlink_android.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterDialog : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_content, container, false)
    }
}