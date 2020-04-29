package com.example.foodlink_android.feature.registration.presentation


import android.graphics.Paint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R
import com.example.foodlink_android.common.helpers.hideKeyboard
import com.example.foodlink_android.widgets.PinEditText

class VerifyEmailFragment: Fragment(){
    companion object {
        fun newInstance(data: Bundle? = null): VerifyEmailFragment {
            val fragment = VerifyEmailFragment()
            fragment.arguments = data
            return fragment
        }
    }

    private lateinit var smsEditText: PinEditText
    private lateinit var returnBtn: TextView
    private lateinit var backBtn: ImageView
    private lateinit var progress: ProgressBar
    private lateinit var timer: TextView
    private var timerCountDown: CountDownTimer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        activity?.hideKeyboard()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.code_access, container, false)
    }

    private fun bindViews(view:View) = with(view){
        timer = findViewById(R.id.timer)
        progress = findViewById(R.id.progress)
        backBtn = findViewById(R.id.back_button)
        returnBtn = findViewById(R.id.return_btn)
        smsEditText = findViewById(R.id.smsEditText)
        smsEditText.focus()
        smsEditText.editableText.clear()
        smsEditText.setOnPinEnteredListener { chr ->
            if (chr.length == 5) {
                openNext()
            }
        }
        timerCountDown = object : CountDownTimer((59 * 1000).toLong(), 1000) {
            override fun onFinish() {
                if (this@VerifyEmailFragment.isVisible) {
                    returnBtn.text = "Отправить повторно"
                    returnBtn.paintFlags = Paint.UNDERLINE_TEXT_FLAG
                    returnBtn.visibility = View.VISIBLE
                    returnBtn.isEnabled = true
                    timer.visibility = View.GONE
                }
            }

            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val minutes = seconds / 60
                timer.text = String.format("%d:%02d", minutes, seconds)
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (isRemoving) {
            timerCountDown?.cancel()
            timerCountDown = null
        }
    }

    private fun setData(){


    }

    private fun openNext() {
        (activity as RegistrationActivityContainer).openFragment(FillDataFragment.newInstance())
    }
}