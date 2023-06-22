package com.jindvir.blue.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.R
import com.jindvir.blue.adapters.FavoriteAdapter
import com.jindvir.blue.models.FavoriteModel
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.FileReader


class FavoritesPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view =  inflater.inflate(R.layout.fragment_favorites_page, container, false)

        val favRv = view.findViewById<RecyclerView>(R.id.rv_favorites)

        val file: File = File(view.context.applicationContext.filesDir, "localDataStorage")
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val stringBuilder = StringBuilder()
        var line = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()

        val responce = stringBuilder.toString()


        val jsonObject = JSONObject(responce)

        val favName =   jsonObject.get("carModel").toString()
        val favImage =   jsonObject.get("carImage") as Int
        val favPrice =   jsonObject.get("carPrice").toString()






        val favlist = ArrayList<FavoriteModel>()

        favlist.add(FavoriteModel(favName , favImage , favPrice))
        favlist.add(FavoriteModel(favName , favImage  , favPrice))
        favlist.add(FavoriteModel(favName , favImage  , favPrice))

        favRv.apply {
            this.layoutManager = LinearLayoutManager(requireContext())
            val adapter = FavoriteAdapter(favlist)
            this.adapter = adapter
        }
        return view
    }

}