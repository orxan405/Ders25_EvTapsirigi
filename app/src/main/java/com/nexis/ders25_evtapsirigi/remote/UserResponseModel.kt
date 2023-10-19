package com.nexis.ders_25_webserivce.remote

import com.google.gson.annotations.SerializedName
import java.net.Inet4Address

data class UserResponseModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AdressResponseModel,
    val phone: String,
    val website: String,
    val company: CompanyModel
)