package com.example.foodlink_android.widgets

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet

class EnterEmailEditText(context: Context) :
    androidx.appcompat.widget.AppCompatEditText(context) {
    init {
        init()
    }

    var drawableRight
            : Bitmap? = null

    var paint
            : Paint? = null

    constructor(context: Context, attributeSet: AttributeSet) : this(context) {
        initDrawables(attributeSet)
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : this(
        context,
        attributeSet
    ) {
        initDrawables(attributeSet)
        init()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }


    private fun init() {
        paint = Paint()
    }


    private fun initDrawables(attributeSet: AttributeSet) {
        for (i in 0 until attributeSet.attributeCount) {
            if (attributeSet.getAttributeName(i).equals("drawableRight")) {
                drawableRight = BitmapFactory.decodeResource(
                    resources,
                    attributeSet.getAttributeResourceValue(i, 0)
                )
            }
        }
    }
}