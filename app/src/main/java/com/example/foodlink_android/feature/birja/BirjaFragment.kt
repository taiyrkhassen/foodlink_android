package com.example.foodlink_android.feature.birja

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodlink_android.R
import com.example.foodlink_android.common.adapters.BirjaAdapter
import com.example.foodlink_android.common.adapters.ChefAdapter
import com.example.foodlink_android.common.adapters.FilterAdapter
import com.example.foodlink_android.feature.chefs.ChefData
import com.example.foodlink_android.feature.profile.FoodData
import kotlinx.android.synthetic.main.birja_fragment.view.*

class BirjaFragment :Fragment(){
    private lateinit var adapterChips:FilterAdapter
    private lateinit var adapterBirjas:BirjaAdapter

    companion object {
        fun newInstance(data: Bundle? = null): BirjaFragment {
            val fragment = BirjaFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.birja_fragment, container, false)
    }
    private fun bind(view: View) = with(view) {

        adapterChips = FilterAdapter(fillFilters())
        chips.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = adapterChips
            adapter?.notifyDataSetChanged()
        }
        chips.adapter?.notifyDataSetChanged()
        Log.i(javaClass.simpleName,chips.adapter.toString())

        adapterBirjas = BirjaAdapter(fillBirja())
        dishes_recycler.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = adapterBirjas
        }
        Log.i(javaClass.simpleName,dishes_recycler.adapter.toString())

        dishes_recycler.adapter?.notifyDataSetChanged()

    }
    fun fillBirja():MutableList<BirjaData>{
        val list = mutableListOf<BirjaData>()
        val listofChefs = mutableListOf<ChefData>()
        listofChefs.add(ChefData("","Rauan Zhanabergen","",4F,4))
        list.add(BirjaData(
            listofChefs,
            listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
            0,
            "","10 min")
        )
        list.add(BirjaData(
            listofChefs,
            listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
            0,
            "","10 min"))
        list.add(BirjaData(
            listofChefs,
            listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
            0,
            "","10 min"))
            list.add(BirjaData(
                listofChefs,
                listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
                0,
                "","10 min"))
        list.add(BirjaData(
            listofChefs,
            listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
            0,
            "","10 min"))
        list.add(BirjaData(
            listofChefs,
            listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
            0,
            "","10 min"))
            list.add(BirjaData(
                listofChefs,
                listOf(Food(0,"","Бургер","10 min",1050.0,"","")),
                0,
                "","10 min"))
        return list
    }
    fun fillFilters():MutableList<FilterData>{
        return listOf(
            FilterData(0,"Все"),
            FilterData(0,"Маркет"),
            FilterData(0,"Лист"),
            FilterData(0,"Блюда"),
            FilterData(0,"Чьи")
        ).toMutableList()
    }
}