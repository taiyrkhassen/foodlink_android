package com.example.foodlink_android.feature.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R

class ProfileFragment : Fragment(){

    private lateinit var lastName: EditText
    private lateinit var firstName: EditText
    private lateinit var address: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var recycler: RecyclerView

    companion object {
        fun newInstance(data: Bundle? = null): ProfileFragment {
            val fragment = ProfileFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile, container, false)

    }

    private fun bindViews(view:View) = with(view){
        lastName = findViewById(R.id.last_name)
        firstName = findViewById(R.id.first_name)
        address = findViewById(R.id.address)
        phoneNumber = findViewById(R.id.phone_number)
        recycler = findViewById(R.id.order_list)


    }

    private fun generateTestFoods(){


    }
}