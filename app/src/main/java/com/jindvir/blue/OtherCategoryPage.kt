package com.jindvir.blue

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jindvir.blue.adapters.OtherItemInfoAdapter
import com.jindvir.blue.models.CarModel

class OtherCategoryPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_category_page)


        val rv = findViewById<RecyclerView>(R.id.other_info_rv)

        val carModeldataList = ArrayList<CarModel>()
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" ,  "Rolls-Royce", getString(R.string.cullinanDesc) , "1.2 Cr"))
        rv.apply {
            this.layoutManager = GridLayoutManager(this@OtherCategoryPage , 2)
            val adapter = OtherItemInfoAdapter(carModeldataList)
            this.adapter = adapter

        }
    }
}