package com.jindvir.blue.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jindvir.blue.R
import com.jindvir.blue.adapters.CarBrandAdapter
import com.jindvir.blue.adapters.CarModelAdapter
import com.jindvir.blue.databinding.FragmentHomePageBinding
import com.jindvir.blue.models.CarBrandModel
import com.jindvir.blue.models.CarModel

class HomePage : Fragment() {

    private  var _binding : FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentHomePageBinding.inflate(inflater, container, false)
        carBrandDataBinder()
        carModelDataBinder()
        return binding.root
    }

    private fun carModelDataBinder(){
        val rvCarModel = _binding?.carModelRv

        val carModeldataList = ArrayList<CarModel>()
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier"))
        carModeldataList.add(CarModel("Cullinan" , R.drawable.default_img, "The Legacy Carrier"))




        rvCarModel?.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL , false)
        val adapter = CarModelAdapter(carModeldataList)
        rvCarModel?.adapter = adapter
    }

    private fun carBrandDataBinder(){
        val rv = _binding?.carBrandRv

        val dataList = ArrayList<CarBrandModel>()
        dataList.add(CarBrandModel("Rolls Royce"))
        dataList.add(CarBrandModel("Mercedes"))
        dataList.add(CarBrandModel("Volvo"))
        dataList.add(CarBrandModel("Audi"))
        dataList.add(CarBrandModel("BMW"))



        rv?.layoutManager = LinearLayoutManager(requireContext() , LinearLayoutManager.HORIZONTAL , false)
        val adapter = CarBrandAdapter(dataList)
        rv?.adapter = adapter
    }
}