package com.jaguarlandrover.interview.xml.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VehicleViewModelFactory(
    private val repository: VehicleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VehicleViewModel(repository) as T
    }
}