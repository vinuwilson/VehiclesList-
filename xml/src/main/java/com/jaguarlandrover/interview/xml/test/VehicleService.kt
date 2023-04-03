package com.jaguarlandrover.interview.xml.test

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class VehicleService(
    private val api: VehicleAPI
) {
    suspend fun getList(): Flow<Result<List<VehicleTest>>> {
        return flow {
            emit(Result.success(api.getVehicles()))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

}
