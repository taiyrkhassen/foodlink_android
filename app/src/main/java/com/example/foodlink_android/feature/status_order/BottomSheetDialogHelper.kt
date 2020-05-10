package com.example.foodlink_android.feature.status_order

import android.app.Dialog
import android.os.Bundle
import com.example.foodlink_android.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BottomSheetDialogHelper: BottomSheetDialogFragment(){

    override fun getTheme(): Int = R.style.BaseBottomSheetDialogLight

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        BottomSheetDialog(
            requireContext(),
            theme
        )

}