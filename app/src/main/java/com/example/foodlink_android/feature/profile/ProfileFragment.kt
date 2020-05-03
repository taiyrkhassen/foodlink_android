package com.example.foodlink_android.feature.profile

import android.os.Bundle
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


class ProfileFragment : Fragment() {

    private lateinit var lastName: EditText
    private lateinit var firstName: EditText
    private lateinit var phoneNumber: EditText
    private lateinit var recycler: RecyclerView
    private lateinit var adapterFood: FoodOrdersAdapter
    private lateinit var addressTop: EditText
    private lateinit var iconLastName: ImageView
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
        var keyLastName = false
        lastName = findViewById(R.id.last_name)
        iconLastName = findViewById(R.id.icon_last_name)

        lastName.apply {
            setOnClickListener {
                iconLastName.setImageResource(R.drawable.ic_done_edit)
                keyLastName = true
            }
        }
        iconLastName.setOnClickListener {
            if(keyLastName){
                iconLastName.setOnClickListener {
                    iconLastName.setImageResource(R.drawable.ic_edit)
                    keyLastName = false
                }
            }
        }

        firstName = findViewById(R.id.first_name)
        addressTop = findViewById(R.id.address)
        phoneNumber = findViewById(R.id.phone_number)
        adapterFood = FoodOrdersAdapter(generateTestFoods())
        recycler = findViewById(R.id.order_list)
        recycler.apply {
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = adapterFood
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