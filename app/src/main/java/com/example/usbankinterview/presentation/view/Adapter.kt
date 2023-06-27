package com.example.usbankinterview.presentation.view

import com.robinhood.spark.SparkAdapter

class Adapter : SparkAdapter() {

    private var yData: List<Int> = emptyList()

    fun setData(yData: List<Int>) {
        this.yData = yData
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return yData.size
    }

    override fun getItem(index: Int): Any? {
        return yData[index]
    }

    override fun getY(index: Int): Float {
        return yData[index].toFloat()
    }
}