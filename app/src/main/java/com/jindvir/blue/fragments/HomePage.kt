package com.jindvir.blue.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.jindvir.blue.ItemDescriptionPage
import com.jindvir.blue.OtherCategoryPage
import com.jindvir.blue.R
import com.jindvir.blue.adapters.CarModelAdapter
import com.jindvir.blue.adapters.OnImageClickListener
import com.jindvir.blue.adapters.OtherCategoryAdapter
import com.jindvir.blue.databinding.FragmentHomePageBinding
import com.jindvir.blue.models.CarModel
import com.jindvir.blue.models.OtherCategoryModel
import java.util.Locale

class HomePage : Fragment() {

    private  var _binding : FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    val carModeldataList = ArrayList<CarModel>()
    private lateinit var adapter : CarModelAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentHomePageBinding.inflate(inflater, container, false)
        carModelDataBinder()

//        testModels()
        itemFilter()
        categoryDataBinder()
        return binding.root
    }


    private fun categoryDataBinder(){
        val rvCategoryModel = _binding?.rvOther

        val otherCategoryList = ArrayList<OtherCategoryModel>()

        otherCategoryList.add(OtherCategoryModel("Scooter"))
        otherCategoryList.add(OtherCategoryModel("Cycle"))
        otherCategoryList.add(OtherCategoryModel("Bike"))
        otherCategoryList.add(OtherCategoryModel("Rickshaw"))

        rvCategoryModel?.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL , false)
        val adapter = OtherCategoryAdapter(otherCategoryList)
        rvCategoryModel?.adapter = adapter

        adapter.setOnClickListener(object : OtherCategoryAdapter.OnClickListener{
            override fun onClick(position: Int, model: OtherCategoryModel) {
                val intent = Intent(requireActivity() , OtherCategoryPage::class.java)
                startActivity(intent)
            }

        })

//        adapter


    }
    private fun carModelDataBinder(){
        val rvCarModel = _binding?.carModelRv

        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" , "Rolls-Royce" , getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier" ,  "Rolls-Royce", getString(R.string.cullinanDesc) , "1.2 Cr"))
        carModeldataList.add(CarModel("AMG" , R.drawable.mercedes_default, "The Legacy Carrier" , "Mercedes" , getString(R.string.amgDesc) , "2.2 Cr"))
        carModeldataList.add(CarModel("AMG" , R.drawable.mercedes_default, "The Legacy Carrier" , "Mercedes",getString(R.string.amgDesc) , "2.2 Cr"))
        carModeldataList.add(CarModel("X3" , R.drawable.bmw_default, "The Legacy Carrier" , "BMW",getString(R.string.x3Desc) , "80 Lacs"))
        carModeldataList.add(CarModel("X3" , R.drawable.bmw_default, "The Legacy Carrier" , "BMW",getString(R.string.x3Desc) , "80 Lacs"))




        rvCarModel?.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL , false)
        adapter = CarModelAdapter(carModeldataList)
        rvCarModel?.adapter = adapter

        adapter.setOnClickListener(object : CarModelAdapter.OnClickListener{
            override fun onClick(position: Int, model: CarModel) {

//                val sp = context?.applicationContext?.getSharedPreferences("carDetails" , Context.MODE_PRIVATE)
//                val editor = sp?.edit()
//
//                editor?.putString("carModelName" , model.carModel)

                val intent = Intent(requireActivity(), ItemDescriptionPage::class.java)
                intent.putExtra("carModel" , model.carModel)
                intent.putExtra("carImage" , model.carImage)
                intent.putExtra("carSign" , model.carSignature)
                intent.putExtra("carDesc" , model.carDescription)
                intent.putExtra("carPrice" , model.carPrice)
                startActivity(intent)
            }
        })
    }

    fun itemFilter() {
        _binding?.searchRec?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                filter(newText)
                return true
            }
        })
    }

    private fun filter(query: String?) {
//        val filteredlist: ArrayList<CarModel> = ArrayList()
        if (query != null){
            val filterList = ArrayList<CarModel>()
            for (i in carModeldataList){
                if(i.carModelFilter.lowercase(Locale.ROOT).contains(query)){
                    filterList.add(i)
                }
            }
            if (filterList.isEmpty())
            {
//                Toast.makeText(requireContext(), "Empty" , Toast.LENGTH_SHORT)
//                    .show()
            }
            else{
                adapter.setFilteredList(filterList)
            }
        }
    }
}