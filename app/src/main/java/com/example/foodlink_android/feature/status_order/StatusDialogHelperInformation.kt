package com.example.foodlink_android.feature.status_order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodlink_android.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_info.*

class StatusDialogHelperInformation : BottomSheetDialogHelper() {

    companion object {
        fun newInstance(data: Bundle? = null): StatusDialogHelperInformation {
            val fragment = StatusDialogHelperInformation()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_info, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        close_btn.setOnClickListener {
            dismiss()
        }
    }
}