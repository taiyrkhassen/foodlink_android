package com.example.foodlink_android.feature.registration.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R

class LoginFragment : Fragment() {

    private lateinit var emailText: EditText

    companion object {
        fun newInstance(data: Bundle? = null): LoginFragment {
            val fragment = LoginFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registration_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
    }

    private fun bindViews(view: View) = with(view) {
        emailText = findViewById(R.id.email)

        emailText.apply {
            val imgAvailable = resources.getDrawable(R.drawable.ic_next_available)
            val imgDisable = resources.getDrawable(R.drawable.ic_disable_next)
            addTextChangedListener(object : TextWatcher {
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s != null) {
                        if (s.length > 5) {
                            setCompoundDrawablesWithIntrinsicBounds(null, null,imgAvailable, null)
                            setOnTouchListener { v, event ->
                               var DRAWABLE_RIGHT = 2
                                if(event.getAction() == MotionEvent.ACTION_UP) {
                                    if(event.rawX >= (right - compoundDrawables[DRAWABLE_RIGHT].bounds.width())) {
                                        openNext()

                                        return@setOnTouchListener true
                                    }
                                }
                                return@setOnTouchListener false
                            }
                        } else {
                            setCompoundDrawablesWithIntrinsicBounds(null, null,imgDisable, null)
                            setOnTouchListener {v, event ->
                                return@setOnTouchListener false
                            }
                        }
                    }

                }

                override fun afterTextChanged(s: Editable?) {}

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
            })
        }
    }

    private fun openNext() {
        (activity as RegistrationActivityContainer).openFragment(VerifyEmailFragment.newInstance(), true)
    }
}