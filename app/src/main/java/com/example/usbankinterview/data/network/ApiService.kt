package com.example.usbankinterview.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

fun interface ApiService {

    @GET
    suspend fun getNumber(@Url url: String): Response<Int>
}