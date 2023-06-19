package com.jindvir.blue.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jindvir.blue.R
import com.jindvir.blue.models.CarBrandModel

class CarBrandAdapter(private var carBrandList : ArrayList<CarBrandModel>) :
    RecyclerView.Adapter<CarBrandAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val carBrandTv = itemView.findViewById<TextView>(R.id.carBrandTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarBrandAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context)
           .inflate(R.layout.car_brand_list , parent , false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarBrandAdapter.ViewHolder, position: Int) {
        val itemModel = carBrandList[position]

        holder.carBrandTv.text = itemModel.carBrand
    }

    override fun getItemCount(): Int {
        return carBrandList.size
    }
}