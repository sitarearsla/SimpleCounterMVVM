package com.sitare.simplecountermvvm

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter = 0

    fun incrementCounter(){
        counter++
    }

    fun counter() = counter.toString()
}