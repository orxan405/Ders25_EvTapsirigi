package com.nexis.ders_25_webserivce.service

import com.nexis.ders_25_webserivce.remote.UserResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    fun getFriends(): Call<List<UserResponseModel?>>

    @GET("users/{userId}")
    fun getFriendById(@Path("userId") userId: String): Call<UserResponseModel?>
}