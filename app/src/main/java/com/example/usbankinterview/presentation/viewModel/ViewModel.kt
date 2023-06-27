package com.example.usbankinterview.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.usbankinterview.domain.GetRandomNumberFromApiUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    private val _numbers = MutableLiveData<List<Int>>()
    val number: LiveData<List<Int>> = _numbers

    private val _isRunning = MutableLiveData(false)

    private var randomNumbers: MutableList<Int> = mutableListOf()

    fun getRandomNumberFromApi() {

        // Ensures that the infinite loop only could be call once, even after a configuration change
        // like a screen rotation.
        if (_isRunning.value == true) {
            return
        }

        // For this example I use the Dispatchers.IO since is the optimized for performing calls to
        // backend, in this case multiple calls to an API.
        viewModelScope.launch(Dispatchers.IO) {

            _isRunning.postValue(true)

            // This infinite loop will be cancelled when ViewModel is cleared
            while (true) {
                val randomNumber = GetRandomNumberFromApiUseCase().invoke()
                randomNumber?.let { notNullRandomNumber ->
                    // Will populated the list with the first 10 positions
                    if (randomNumbers.size < 10) {
                        randomNumbers.add(0, notNullRandomNumber)
                    }
                    // Will keep updating the list under a FIFO (First In First Out) schema,
                    // adding the new position to the first position and removing the last position.
                    // In a real life project this approach also could be done using a Queue data
                    // structure, for simplicity I decided to use a regular list approach for this example.
                    else {
                        randomNumbers.add(0, notNullRandomNumber)
                        randomNumbers.removeAt(10)
                    }
                }
                // Updates the value of the random numbers, and updates the value that is been observed
                // in the activity
                _numbers.postValue(randomNumbers)

                // Waits 1 second before executing the next iteration of the loop
                delay(1000)
            }
        }
    }
}