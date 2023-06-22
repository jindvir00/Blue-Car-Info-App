package com.jindvir.blue.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.R
import com.jindvir.blue.models.CarModel
import com.jindvir.blue.models.OtherCategoryModel
import java.util.Locale


class OtherCategoryAdapter(private var modelList : ArrayList<OtherCategoryModel>): RecyclerView.Adapter<OtherCategoryAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val categoryTv: TextView = itemView.findViewById(R.id.other_category_tv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.other_category_list ,parent , false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPointer = modelList[position]

        holder.categoryTv.text = itemPointer.categoryName
        holder.categoryTv.setOnClickListener {
            Toast.makeText(it.context , "Hello" , Toast.LENGTH_SHORT).show()
        }

    }




}