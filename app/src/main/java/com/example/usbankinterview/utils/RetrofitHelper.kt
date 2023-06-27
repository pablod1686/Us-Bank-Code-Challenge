package com.example.usbankinterview.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.random.org/integers/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getUniqueEndPoint(): String {
        return "?num=1&min=1&max=100&col=1&base=10&format=plain&rnd=new"
    }

}