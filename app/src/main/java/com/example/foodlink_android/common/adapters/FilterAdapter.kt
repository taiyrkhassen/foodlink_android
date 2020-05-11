package com.example.foodlink_android.common.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.feature.birja.FilterData
import kotlinx.android.synthetic.main.item_chip.view.*
import org.jetbrains.anko.backgroundColor

class FilterAdapter(var listOfFilters : List<FilterData>) :RecyclerView.Adapter<FilterAdapter.FilterViewHolder>(){

    class FilterViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
        fun bind(action:()->Unit){
            itemView.setOnClickListener {
                action()
                it.chip_background.backgroundColor = R.color.chip_background_selected
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        return FilterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chip,parent,false))
    }

    override fun getItemCount(): Int {
        return listOfFilters.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.itemView.chip_background.setBackgroundColor(R.color.white)
        holder.itemView.chip_name.text = listOfFilters.get(position).filerName
        holder.bind(){
            notifyDataSetChanged()
        }
    }
}