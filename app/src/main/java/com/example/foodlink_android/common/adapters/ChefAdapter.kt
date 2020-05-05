package com.example.foodlink_android.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodlink_android.R
import com.example.foodlink_android.feature.chefs.ChefData
import com.example.foodlink_android.feature.profile.FoodData
import kotlinx.android.synthetic.main.item_chef.view.*

class ChefAdapter(
    private var chefList: ArrayList<ChefData>? = null
) : RecyclerView.Adapter<ChefAdapter.ChefViewHolder>() {

    init {
        if (chefList == null) {
            chefList = ArrayList()
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChefViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_chef, parent, false)
        return ChefViewHolder(view)
    }

    override fun getItemCount(): Int = chefList?.size ?: 0



    override fun onBindViewHolder(holder: ChefViewHolder, position: Int) {
        holder.bind(chefList?.get(position))
    }

    inner class ChefViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: ChefData?) = with(view) {
            if (!item?.chef_image.isNullOrEmpty()) {
                Glide.with(context)
                    .load(item?.chef_image)
                    .apply(RequestOptions().placeholder(R.drawable.me_and_me))
                    .into(chefs_ava)
            }
            chefs_ava.setImageResource(R.drawable.me_and_me)
            chef_name.text = item?.chef_name
            chef_description.text = item?.chef_description
            number_orders.text = "${item?.number_order} orders"
            rating_chef.rating = item?.chef_rating ?: 0.0f

        }
    }

    fun addAll(data: List<FoodData>) {
        chefList?.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun clearAll() {
        chefList?.clear()
        notifyDataSetChanged()
    }
}