package com.jaguarlandrover.interview.xml.test

import retrofit2.http.GET

interface VehicleAPI {

    @GET("vehicles")
    suspend fun getVehicles(): List<VehicleTest>
}