package com.example.usbankinterview.domain

import com.example.usbankinterview.data.repository.RandomNumberRepository

class GetRandomNumberFromApiUseCase {

    // In a real life project this instance could be be avoid using dependency injection, and passed
    // as a parameter to the constructor.
    private val repository = RandomNumberRepository()

    suspend operator fun invoke() : Int? {
        return repository.getRandomNumberFromApi()
    }
}