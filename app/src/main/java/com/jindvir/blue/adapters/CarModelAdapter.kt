package com.jindvir.blue.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.ItemDescriptionPage
import com.jindvir.blue.R
import com.jindvir.blue.models.CarModel
import java.util.Locale


class CarModelAdapter(private var carModelList : ArrayList<CarModel>): RecyclerView.Adapter<CarModelAdapter.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carModelImage = itemView.findViewById<ImageView>(R.id.car_model_img)
        val carModelName = itemView.findViewById<TextView>(R.id.car_model_name_tv)
        val carModelSign = itemView.findViewById<TextView>(R.id.car_model_sign_tv)
        val carModelFilter = itemView.findViewById<TextView>(R.id.car_model_brand_filter)

    }

    fun setFilteredList(itemlist: ArrayList<CarModel>){
        this.carModelList = itemlist
        notifyDataSetChanged()
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
        holder.carModelFilter.text = itemPointer.carModelFilter


        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, itemPointer )
            }
        }

    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: CarModel)
    }




}