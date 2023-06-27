package com.example.usbankinterview.data.model

// Finally this data class was not necessary for this particular simple example since the API retrieves
// a single Int, in a real life application the API should retrieve complex Json strings that should be
// converted into the data class (object) with the help of Gson library.
data class RandomNumber(
    val number: Int?
)
