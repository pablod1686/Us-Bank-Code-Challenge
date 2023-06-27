package com.example.usbankinterview.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.usbankinterview.databinding.ActivityMainBinding
import com.example.usbankinterview.presentation.viewModel.ViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniSparkView()

        viewModel.getRandomNumberFromApi()

        // Using the observable pattern of LiveData, the adapter will be updated every second
        // when a new number has been retrieved from the API
        viewModel.number.observe(this) { randomNumbers ->
            adapter.setData(randomNumbers)
        }
    }

    // Initialization of the SparkView (Graph)
    private fun iniSparkView() {
        adapter = Adapter()
        binding.sparkview.adapter = adapter
    }
}