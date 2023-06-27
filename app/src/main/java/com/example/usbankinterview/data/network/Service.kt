package com.example.usbankinterview.data.network

import com.example.usbankinterview.utils.RetrofitHelper

class Service {

    // In a real life project these two instances could be be avoid using dependency injection.
    // Injecting them as parameters of the constructor
    private val retrofit = RetrofitHelper.getRetrofit().create(ApiService::class.java)
    private val endPoint = RetrofitHelper.getUniqueEndPoint()

    suspend fun getRandomNumber(): Int? {
        val call = retrofit.getNumber(endPoint)
        return call.body()
    }

}