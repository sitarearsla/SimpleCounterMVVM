package com.sitare.simplecountermvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CounterViewModelFactory(val previousCounter: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)){
            return CounterViewModel(previousCounter) as T
        } else {
            throw IllegalArgumentException("Unknown View Model")
        }
    }
}