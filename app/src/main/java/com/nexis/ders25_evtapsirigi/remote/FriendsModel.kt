package com.nexis.ders_25_webserivce.remote

import com.google.gson.annotations.SerializedName

data class FriendsModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int
)
