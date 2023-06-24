package com.jindvir.blue

import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jindvir.blue.databinding.ActivityItemDescriptionPageBinding
import com.jindvir.blue.datastore.WriteObjectFile
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileInputStream
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class ItemDescriptionPage : AppCompatActivity()  {

    private  lateinit var floatinfFavorite : FloatingActionButton
//    private val filePath = "data.json"
    lateinit var writeObjectFile : WriteObjectFile
    
    private lateinit var _binding : ActivityItemDescriptionPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = ActivityItemDescriptionPageBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val textView : TextView = findViewById(R.id.view_car_info_desc)
        floatinfFavorite = findViewById(R.id.floating_favorite)
//        textView.text = getString(R.string.desc)

        textView.movementMethod = ScrollingMovementMethod()


        val iin = intent
        val model = iin.getStringExtra("carModel")
        val sign = iin.getStringExtra("carSign")
        val image = iin.getIntExtra("carImage", 0)
        val desc = iin.getStringExtra("carDesc")
        val price = iin.getStringExtra("carPrice")


            _binding.carModelInfoName.text = model
            _binding.carModelInfoDescription.text = sign
            _binding.imageView.setImageResource(image)
            _binding.viewCarInfoDesc.text = desc




        var counterClickFav = 0

        floatinfFavorite.setOnClickListener {

            if (model != null) {
                if (sign != null) {
                    jsonHandling(model , image , sign)
                }
            }
//            startActivity(Intent(this@ItemDescriptionPage , FavoritePage::class.java))


            ++counterClickFav
            if(counterClickFav%2 == 0)
            {
                floatinfFavorite.setImageIcon(Icon.createWithResource(this , R.drawable.baseline_favorite_border_24))
            }
            else{
                floatinfFavorite.setImageIcon(Icon.createWithResource(this , R.drawable.baseline_favorite_24))
            }
        }

    }

    private fun jsonHandling(carModel :String , carImage: Int , carPrice: String){


        val fileJson = File(applicationContext.filesDir, "favLocalData")
        val jsonArray = JSONArray()

        if (!fileJson.exists()){
            val favoriteObj = JSONObject()
            try {
                favoriteObj.put("carModel", carModel)
                favoriteObj.put("carImage", carImage)
                favoriteObj.put("carPrice", carPrice)
                jsonArray.put(favoriteObj)
                val jsonObj = JSONObject()
                jsonObj.put("favorites" , jsonArray)
                writeJsonFile(fileJson,jsonObj.toString());

            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        else{
            val strFileJson = getStringFromFile(fileJson.toString())
            val previousJsonObj = JSONObject(strFileJson)
            val array: JSONArray = previousJsonObj.getJSONArray("favorites")
            val newJsonObj = JSONObject()

            newJsonObj.put("carModel", carModel)
            newJsonObj.put("carImage", carImage)
            newJsonObj.put("carPrice", carPrice)

            array.put(newJsonObj);

            val currentJsonObject = JSONObject()
            currentJsonObject.put("favorites", array)
            writeJsonFile(fileJson , currentJsonObject.toString())
        }




    }

    @Throws(java.lang.Exception::class)
    fun getStringFromFile(filePath: String?): String {
        val fl = filePath?.let { File(it) }
        val fin = FileInputStream(fl)
        val ret = convertStreamToString(fin)
        //Make sure you close all streams.
        fin.close()
        return ret
    }

    @Throws(Exception::class)
    fun convertStreamToString(`is`: InputStream?): String {
        val reader = BufferedReader(InputStreamReader(`is`))
        val sb = StringBuilder()
        var line: String? = null
        while (reader.readLine().also { line = it } != null) {
            sb.append(line).append("\n")
        }
        return sb.toString()
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
}