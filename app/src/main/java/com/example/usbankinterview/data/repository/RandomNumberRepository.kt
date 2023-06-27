package com.example.usbankinterview.data.repository

import com.example.usbankinterview.data.network.Service

class RandomNumberRepository {

    // In a real life project this instance could be be avoid using dependency injection, and passed
    // as a parameter to the constructor.
    private val service = Service()

    //In a real life application this repository will have the responsibility of fetching the required
    // data from different sources (Api, Remote Database, local database, etc)
    //For this simple example, we only have one method for fetching the data from the API provided
    suspend fun getRandomNumberFromApi() : Int? {
        return service.getRandomNumber()
    }

}