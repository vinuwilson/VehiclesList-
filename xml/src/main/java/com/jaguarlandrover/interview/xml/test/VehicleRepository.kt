package com.jaguarlandrover.interview.xml.test

import kotlinx.coroutines.flow.Flow

class VehicleRepository(
    private val service : VehicleService
) {

    suspend fun getVehicleList(): Flow<Result<List<VehicleTest>>> = service.getList()

}
