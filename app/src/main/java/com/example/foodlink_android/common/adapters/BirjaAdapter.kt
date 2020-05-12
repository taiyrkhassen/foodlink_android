package com.example.foodlink_android.common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.feature.birja.BirjaData
import kotlinx.android.synthetic.main.item_card_birja.view.*

class BirjaAdapter(var listOfBirjas:List<BirjaData>) :RecyclerView.Adapter<BirjaAdapter.BirjaHolder>(){

    class BirjaHolder(val itemview: View):RecyclerView.ViewHolder(itemview){
        fun bind(){
            itemview.want_it.setOnClickListener {
                // action
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirjaHolder {
        return BirjaHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card_birja,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfBirjas.size
    }

    override fun onBindViewHolder(holder: BirjaHolder, position: Int) {
        var price:Double = 0.0
        holder.itemView.name_surname.text = listOfBirjas.get(position).chef.get(0).chef_name
        listOfBirjas.get(position).foods.forEach{
            price+=it.price
        }
        holder.itemView.price.text = price.toString()
        holder.itemView.time_of_cook.text = listOfBirjas.get(position).time
        holder.itemView.name_dish.text = listOfBirjas.get(position).foods.get(0).name
        holder.bind()
    }
}