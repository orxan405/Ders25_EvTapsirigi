package com.nexis.ders_25_webserivce.remote

data class AdressResponseModel(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoResponseModel
)
