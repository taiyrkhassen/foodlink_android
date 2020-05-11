package com.example.foodlink_android.feature.registration.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.foodlink_android.R
import com.example.foodlink_android.common.constants.ApplicationConstants
import com.example.foodlink_android.feature.CommonMainActivity
import de.hdodenhof.circleimageview.CircleImageView

class FillDataFragment : Fragment() {

    private lateinit var lastName: EditText
    private lateinit var firstName: EditText
    private lateinit var address: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var nextBtn: CircleImageView

    private lateinit var listenerText: TextWatcher

    companion object {
        fun newInstance(data: Bundle? = null): FillDataFragment {
            val fragment = FillDataFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_data_filling, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
    }

    private fun bindViews(view: View) = with(view) {
        lastName = findViewById(R.id.last_name)
        firstName = findViewById(R.id.first_name)
        address = findViewById(R.id.address)
        phoneNumber = findViewById(R.id.phone_number)
        nextBtn = findViewById(R.id.next_fill_data)
        textWatcher()
        lastName.addTextChangedListener(listenerText)
        firstName.addTextChangedListener(listenerText)
        address.addTextChangedListener(listenerText)
        phoneNumber.addTextChangedListener(listenerText)

    }

    private fun openCommon() {
        CommonMainActivity.start(
            context, page = ApplicationConstants.TAB to 4
        )
        activity?.finish()
    }


    private fun textWatcher(){
        listenerText = object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val firstNameText = firstName.text.toString().trim()
                val lastNameText = lastName.text.toString().trim()
                val address = address.text.toString().trim()
                val phone = phoneNumber.text.toString().trim()

                if (firstNameText.isNotEmpty() && lastNameText.isNotEmpty() && address.isNotEmpty() && phone.isNotEmpty()) {
                    nextBtn.setImageResource(R.drawable.ic_fill_data_available)
                    nextBtn.isEnabled = true
                    nextBtn.setOnClickListener {
                        openCommon()
                    }
                } else {
                    nextBtn.setImageResource(R.drawable.ic_fill_data_next)
                    nextBtn.isEnabled = false
                }
            }

        }
    }
}