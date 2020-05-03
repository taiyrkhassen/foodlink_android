package com.example.foodlink_android.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodlink_android.R
import com.example.foodlink_android.feature.profile.FoodData
import kotlinx.android.synthetic.main.order_history_item.view.*

class FoodOrdersAdapter(
    private var listOrders: ArrayList<FoodData>? = null
) : RecyclerView.Adapter<FoodOrdersAdapter.FoodOrderViewHolder>() {

    init {
        if (listOrders == null) {
            listOrders = ArrayList()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodOrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.order_history_item, parent, false)
        return FoodOrderViewHolder(view)

    }

    override fun getItemCount(): Int = listOrders?.size ?: 0

    override fun onBindViewHolder(holder: FoodOrderViewHolder, position: Int) {
        holder.bind(listOrders?.get(position))
    }

    fun addAll(data: List<FoodData>) {
        listOrders?.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun clearAll() {
        listOrders?.clear()
        notifyDataSetChanged()
    }


    inner class FoodOrderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: FoodData?) = with(view) {
//            if(!item?.image.isNullOrEmpty()){
//                Glide.with(context)
//                    .load(item?.image)
//                    .apply(RequestOptions().placeholder(R.drawable.food_placeholder))
//                    .into(image_food)
//            }
            name_food.text = item?.nameFood
            date_order.text = item?.dataOrder
            time_order.text = item?.timeOrder
        }

    }
}