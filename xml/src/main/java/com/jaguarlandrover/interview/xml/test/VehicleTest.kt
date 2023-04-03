package com.jaguarlandrover.interview.xml.test

import android.os.Parcelable
import com.jaguarlandrover.interview.xml.Images
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class VehicleTest(
    val brand: String,
    val nickname: String,
    val model: String,
    val description: String,
    val colour: String,
    val registration: String,
    val images: Images
) : Parcelable

@Serializable
@Parcelize
data class Images1(val primary: String) : Parcelable