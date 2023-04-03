package com.jaguarlandrover.interview.xml.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jaguarlandrover.interview.R
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit


class VehiclesTestFragment : Fragment() {

    lateinit var vehicleViewModelFactory: VehicleViewModelFactory

    private lateinit var viewModel: VehicleViewModel

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://6405b0e040597b65de3df162.mockapi.io/")
            .addConverterFactory(Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(MediaType.parse("application/json")!!))
            .build()
    }


    private val api = retrofit.create(VehicleAPI::class.java)
    private val service  = VehicleService(api)
    private val repository = VehicleRepository(service)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vehicles_test_list, container, false)

        setupViewModel()
        observeVehicleList(view)

        return view
    }

    private fun observeVehicleList(view: View) {
        viewModel.vehicleList.observe(this as LifecycleOwner) { list ->
            if (list.getOrNull() != null) {
                setupListView(view, list)
            } else
                Toast.makeText(requireContext(), "Failure in API", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListView(view: View, list: Result<List<VehicleTest>>) {
        with(view as  RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyItemRecyclerViewAdapter(list.getOrNull()!!)
        }
    }

    private fun setupViewModel() {
        vehicleViewModelFactory = VehicleViewModelFactory(repository)
        viewModel = ViewModelProvider(this, vehicleViewModelFactory)[VehicleViewModel::class.java]
    }

    companion object {

        @JvmStatic
        fun newInstance(columnCount: Int) =
            VehiclesTestFragment().apply {
            }
    }
}