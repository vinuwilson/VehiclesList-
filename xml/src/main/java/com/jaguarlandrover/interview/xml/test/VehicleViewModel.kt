package com.jaguarlandrover.interview.xml.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData

class VehicleViewModel(
    private val repository : VehicleRepository
) : ViewModel(){

   val vehicleList = liveData {
       emitSource(repository.getVehicleList().asLiveData())
   }
}