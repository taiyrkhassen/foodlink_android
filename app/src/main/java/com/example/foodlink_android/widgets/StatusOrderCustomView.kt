package com.example.foodlink_android.widgets

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

class StatusOrderCustomView(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var contentHeight: Int = 0
    private var contentWidth: Int = 0

    companion object{
        private const val FIRST_STAGE = 25
        private const val SECOND_STAGE = 50
        private const val THIRD_STAGE = 75
        private const val FOURTH_STAGE = 100

        private const val FIRST_STAGE_COLOR = Color.RED
        private const val SECOND_STAGE_COLOR = Color.BLUE
        private const val THIRD_STAGE_COLOR = Color.YELLOW
        private const val FOURTH_STAGE_COLOR = Color.GREEN

    }

}