package com.example.foodlink_android.feature.birja

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodlink_android.R
import com.example.foodlink_android.common.adapters.BirjaAdapter
import com.example.foodlink_android.common.adapters.ChefAdapter
import com.example.foodlink_android.common.adapters.FilterAdapter
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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.birja_fragment, container, false)
    }
    private fun bind(view: View) = with(view) {

        adapterChips = FilterAdapter()
        adapterChips.listOfFilters = emptyList()
        chips.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = adapterChips
        }

        adapterBirjas = BirjaAdapter()
        adapterBirjas.listOfBirjas = emptyList()
        dishes_recycler.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = adapterBirjas
        }
    }
}