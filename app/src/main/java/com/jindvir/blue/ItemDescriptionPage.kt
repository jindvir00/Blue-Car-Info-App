package com.jindvir.blue

import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.gson.JsonObject
import com.jindvir.blue.databinding.ActivityItemDescriptionPageBinding
import com.jindvir.blue.datastore.WriteObjectFile
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.lang.Exception


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

        val jsonObject = JSONObject()

        jsonObject.put("carModel" , carModel)
        jsonObject.put("carImage" , carImage)
        jsonObject.put("carPrice" , carPrice)

        val userString: String = jsonObject.toString()

        try {
            val file: File = File(applicationContext.filesDir, "localDataStorage")
            val fileWriter = FileWriter(file)
            val bufferedWriter = BufferedWriter(fileWriter)
            bufferedWriter.write(userString)
            bufferedWriter.close()

            Toast.makeText(this , "Added To Favorites" , Toast.LENGTH_SHORT).show()

        }catch(e:Exception){
            Toast.makeText(this , e.message , Toast.LENGTH_SHORT).show()
        }

    }
}