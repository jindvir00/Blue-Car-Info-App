package com.jindvir.blue.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.wallet.IsReadyToPayRequest
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import com.google.android.gms.wallet.WalletConstants
import com.google.gson.JsonArray
import com.jindvir.blue.R
import com.jindvir.blue.adapters.FavoriteAdapter
import com.jindvir.blue.models.FavoriteModel
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException


class FavoritesPage : Fragment() {

    private lateinit var view : View
    private var carModel: ArrayList<String> = ArrayList()
    private var carImage: ArrayList<Int> = ArrayList()
    private var carPrice: ArrayList<String> = ArrayList()
    private lateinit var removeBtn : Button
    private lateinit var paymentsClient: PaymentsClient
    private lateinit var payLl : LinearLayout
    private lateinit var cancelPremium : Button
    private lateinit var payPremium : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment


        view =  inflater.inflate(R.layout.fragment_favorites_page, container, false)

        val favRv = view.findViewById<RecyclerView>(R.id.rv_favorites)
        payLl = view.findViewById(R.id.paymentLinerLayout)
        cancelPremium = view.findViewById<Button>(R.id.cancelPremium)
        payPremium = view.findViewById(R.id.payPremium)

//        removeBtn  = view.findViewById(R.id.removeBtn)

        val fileJson = File(view.context.filesDir, "favLocalData")
        val obj = JSONObject(readFileAsTextUsingInputStream(fileJson.toString()))
        val userArray = obj.getJSONArray("favorites")
        val jsonArray = JsonArray()
        val list = ArrayList<String>()
        try {

            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                carModel.add(userDetail.getString("carModel"))
                carImage.add(userDetail.getInt("carImage"))
                carPrice.add(userDetail.getString("carPrice"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }

        val dataArray = arrayListOf<FavoriteModel>()

        for (i in carModel.indices){
            val data = FavoriteModel(carModel[i] , carImage[i] ,carPrice[i])
            dataArray.add(data)
        }

        favRv.apply {
            this.layoutManager = LinearLayoutManager(requireContext())
            val adapter = FavoriteAdapter(dataArray , context.applicationContext)
            this.adapter = adapter

            adapter.setOnClickListener(object : FavoriteAdapter.OnClickListener{
                override fun onClick(position: Int, model: FavoriteModel) {
                    payLl.visibility = View.VISIBLE

                    payLl.animate().translationY(0f);
                    cancelPremium.setOnClickListener {
                        payLl.animate().translationY(payLl.height.toFloat());

                    }
                }
            })
        }
        return view
    }
    private fun readFileAsTextUsingInputStream(fileName: String)
            = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)



}