package com.sitare.simplecountermvvm

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter = 0

    fun onButtonClicked(){
        counter++
    }

    fun counter() = counter.toString()
}