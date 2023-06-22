package com.jindvir.blue.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.jindvir.blue.R
import com.jindvir.blue.models.FavoriteModel

class FavoriteAdapter(private var favList : ArrayList<FavoriteModel>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)   {

        val favModel : TextView = itemView.findViewById(R.id.favoriteName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_item_list , parent , false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemFav = favList[position]

        holder.favModel.text = itemFav.favoriteModelName
    }
}