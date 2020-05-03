package com.example.foodlink_android.feature.profile

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.common.adapters.FoodOrdersAdapter
import com.example.foodlink_android.common.helpers.hideKeyboard


class ProfileFragment : Fragment() {

    private lateinit var lastName: EditText
    private lateinit var firstName: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var adapterFood: FoodOrdersAdapter
    private lateinit var addressTop: EditText

    private lateinit var iconLastName: ImageView
    private lateinit var iconFirstName: ImageView
    private lateinit var iconAddress: ImageView
    private lateinit var iconPhoneNumber: ImageView

    private var keyLastName = false
    private var keyFirstName = false
    private var keyPhoneNumber = false
    private var keyAddress = false


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
    }

    private fun bindViews(view: View) = with(view) {

        lastName = findViewById(R.id.last_name)
        firstName = findViewById(R.id.first_name)
        addressTop = findViewById(R.id.address)
        phoneNumber = findViewById(R.id.phone_number)

        iconLastName = findViewById(R.id.icon_last_name)
        iconFirstName = findViewById(R.id.icon_first_name)
        iconAddress = findViewById(R.id.icon_address)
        iconPhoneNumber = findViewById(R.id.icon_phone_number)

        generateFunctionToEdit(lastName)
        generateFunctionToEdit(firstName)
        generateFunctionToEdit(addressTop)
        generateFunctionToEdit(phoneNumber)


        adapterFood = FoodOrdersAdapter(generateTestFoods())
        recycler = findViewById(R.id.order_list)
        recycler.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = adapterFood
        }


    }

    private fun generateFunctionToEdit(editText: EditText){

        when(editText.tag){
            "1" ->{
                lastName.apply {
                    addTextChangedListener(object : TextWatcher{
                        override fun afterTextChanged(s: Editable?) {

                        }

                        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                        }

                        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                            iconLastName.setImageResource(R.drawable.ic_done_edit)
                            keyLastName = true
                            lastName.isCursorVisible = keyLastName
                        }

                    })
                }
                iconLastName.setOnClickListener {
                    if(keyLastName){
                        //send info to back
                        iconLastName.setOnClickListener {
                            iconLastName.setImageResource(R.drawable.ic_edit)
                            activity?.hideKeyboard()
                            keyLastName = false
                            lastName.isCursorVisible = keyLastName
                        }
                    }
                }
            }
            "2"->{
                firstName.apply {
                    addTextChangedListener(object :TextWatcher{
                        override fun afterTextChanged(s: Editable?) {}

                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {}

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            iconFirstName.setImageResource(R.drawable.ic_done_edit)
                            keyFirstName = true
                            isCursorVisible = keyFirstName
                        }


                    })
                }
                iconFirstName.setOnClickListener {
                    if(keyFirstName){
                        iconFirstName.setOnClickListener {
                            iconFirstName.setImageResource(R.drawable.ic_edit)
                            activity?.hideKeyboard()
                            keyFirstName = false
                            firstName.isCursorVisible = keyLastName
                        }
                    }
                }
            }
            "3"->{
                addressTop.apply {
                    addTextChangedListener(object :TextWatcher{
                        override fun afterTextChanged(s: Editable?) {}

                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {}

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            iconAddress.setImageResource(R.drawable.ic_done_edit)
                            keyAddress = true
                            isCursorVisible = keyAddress
                        }


                    })
                }
                iconAddress.setOnClickListener {
                    if(keyAddress){
                        iconAddress.setOnClickListener {
                            iconAddress.setImageResource(R.drawable.ic_edit)
                            activity?.hideKeyboard()
                            keyAddress = false
                            firstName.isCursorVisible = keyAddress
                        }
                    }
                }

            }
            "4"->{
                phoneNumber.apply {
                    addTextChangedListener(object :TextWatcher{
                        override fun afterTextChanged(s: Editable?) {}

                        override fun beforeTextChanged(
                            s: CharSequence?,
                            start: Int,
                            count: Int,
                            after: Int
                        ) {}

                        override fun onTextChanged(
                            s: CharSequence?,
                            start: Int,
                            before: Int,
                            count: Int
                        ) {
                            iconPhoneNumber.setImageResource(R.drawable.ic_done_edit)
                            keyPhoneNumber = true
                            isCursorVisible = keyPhoneNumber
                        }


                    })
                }
                iconPhoneNumber.setOnClickListener {
                    if(keyPhoneNumber){
                        iconPhoneNumber.setOnClickListener {
                            iconPhoneNumber.setImageResource(R.drawable.ic_edit)
                            activity?.hideKeyboard()
                            keyPhoneNumber = false
                            firstName.isCursorVisible = keyPhoneNumber
                        }
                    }
                }
            }
        }
    }
    private fun generateTestFoods(): ArrayList<FoodData> {
        return arrayListOf(
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            ),
            FoodData(
                null,
                "Чизбургер",
                "25 апреля",
                "19:45"
            )
        )
    }
}