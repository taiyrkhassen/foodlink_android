package com.example.foodlink_android.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodlink_android.R
import com.example.foodlink_android.feature.status_order.StatusOrder
import kotlinx.android.synthetic.main.order_status_item.view.*

class StatusOrderAdapter(
    var ordersList: ArrayList<StatusOrder>? = null
) : RecyclerView.Adapter<StatusOrderAdapter.StatusOrderViewHolder>() {

    interface ClickListenerInfo {
        fun infoClick()
    }

    private var listener: ClickListenerInfo? = null

    fun setClickInfo(listener: ClickListenerInfo) {
        this.listener = listener
    }

    init {
        if (ordersList == null) {
            ordersList = ArrayList()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusOrderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.order_status_item, parent, false)
        return StatusOrderViewHolder(view)
    }

    override fun getItemCount(): Int = ordersList?.size ?: 0

    override fun onBindViewHolder(holder: StatusOrderViewHolder, position: Int) {
        holder.bind(ordersList?.get(position))
    }

    inner class StatusOrderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: StatusOrder?) = with(view) {
            if (!item?.imageChef.isNullOrEmpty()) {
                Glide.with(context)
                    .load(item?.imageChef)
                    .apply(RequestOptions().placeholder(R.drawable.me_and_me))
                    .into(chef_picture)
            }
            if (!item?.imageBig.isNullOrEmpty()) {
                //sprosit how to do this
            }
            price_order.text = item?.price.toString() + "₸"
            time_order.text = item?.time
            name_food_order.text = item?.descriptionOrder
            when (item?.status) {
                1 -> {
                    status_order_image.setImageResource(R.drawable.ic_order_stage_1)
                }
                2 -> {
                    status_order_image.setImageResource(R.drawable.ic_order_stage_2)
                }
                3 -> {
                    status_order_image.setImageResource(R.drawable.ic_order_stage_3)
                }
                else -> {
                    status_order_image.setImageResource(R.drawable.ic_full_order)
                }
            }
            icon_info.setOnClickListener {
                listener?.infoClick()
            }
        }

    }
}