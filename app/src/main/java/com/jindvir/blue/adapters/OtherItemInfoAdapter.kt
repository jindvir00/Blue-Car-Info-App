package com.jindvir.blue.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.R
import com.jindvir.blue.models.CarModel


class OtherItemInfoAdapter(private var otherModelList : ArrayList<CarModel>): RecyclerView.Adapter<OtherItemInfoAdapter.ViewHolder>(){

    private var onClickListener: OnClickListener? = null

    //TODO change variable names

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carModelImage = itemView.findViewById<ImageView>(R.id.car_model_img)
        val carModelName = itemView.findViewById<TextView>(R.id.car_model_name_tv)
        val carModelSign = itemView.findViewById<TextView>(R.id.car_model_sign_tv)
        val carModelFilter = itemView.findViewById<TextView>(R.id.car_model_brand_filter)

    }

    fun setFilteredList(itemlist: ArrayList<CarModel>){
        this.otherModelList = itemlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.other_category_info_item ,parent , false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return otherModelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPointer = otherModelList[position]

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