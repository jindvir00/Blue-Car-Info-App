package com.jindvir.blue.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.jindvir.blue.R
import com.jindvir.blue.models.FavoriteModel
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.util.logging.Handler


class FavoriteAdapter(private var dataList : ArrayList<FavoriteModel> , private var context: Context) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val favModel: TextView = itemView.findViewById(R.id.favoriteName)
        val favImage: ImageView = itemView.findViewById(R.id.favoriteImage)
        val favRemoveButton: Button = itemView.findViewById(R.id.removeBtn)
        val placeOrderButton: Button = itemView.findViewById(R.id.buyBtn)
        val rlFav: RelativeLayout = itemView.findViewById(R.id.rlFav)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.favorite_item_list, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemFav = dataList[position]

        val fileJson = File(context.filesDir, "favLocalData")
        val obj = JSONObject(readFileAsTextUsingInputStream(fileJson.toString()))
        val userArray = obj.getJSONArray("favorites")

        holder.favModel.text = itemFav.favoriteModelName
        holder.favImage.setImageResource(itemFav.favoriteModelImage)
        holder.favRemoveButton.setOnClickListener {

//            holder.rlFav.animate().translationX(holder.rlFav.width.toFloat())

            dataList.removeAt(position)
            notifyDataSetChanged()
            userArray.remove(position)
            val currentJsonObject = JSONObject()
            currentJsonObject.put("favorites", userArray)
            writeJsonFile(fileJson , currentJsonObject.toString())



           Toast.makeText(context.applicationContext , "Removed From Favorite" , Toast.LENGTH_SHORT).show()
        }

        holder.placeOrderButton.setOnClickListener {

            if (onClickListener != null){
                onClickListener!!.onClick(position , itemFav)
            }
        }

    }



    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: FavoriteModel)
    }

    fun writeJsonFile(file: File, json: String?) {
        var bufferedWriter: BufferedWriter? = null
        try {
            if (!file.exists()) {
                Log.e("App", "file not exist")
                file.createNewFile()
            }
            val fileWriter = FileWriter(file)
            bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(json)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bufferedWriter?.close()
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
    }
    fun readFileAsTextUsingInputStream(fileName: String)
            = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
}
