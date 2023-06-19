package com.jindvir.blue.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.R
import com.jindvir.blue.models.CarModel

class CarModelAdapter(private val carModelList : ArrayList<CarModel>): RecyclerView.Adapter<CarModelAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carModelImage = itemView.findViewById<ImageView>(R.id.car_model_img)
        val carModelName = itemView.findViewById<TextView>(R.id.car_model_name_tv)
        val carModelSign = itemView.findViewById<TextView>(R.id.car_model_sign_tv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_model_list ,parent , false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPointer = carModelList[position]

        holder.carModelName.text = itemPointer.carModel
        holder.carModelImage.setImageResource(itemPointer.carImage)
        holder.carModelSign.text = itemPointer.carSignature

    }


}