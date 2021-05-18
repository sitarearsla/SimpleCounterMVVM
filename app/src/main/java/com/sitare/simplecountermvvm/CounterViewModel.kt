package com.sitare.simplecountermvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    /**
     * LATEINIT - LATE INITIALIZATION
     * LAZY -
     * BY LAZY -
     *
     * val foo: Int by lazy {
     * println("working")
     * 4 * 4
     * }
     *
     * when created the result of 4 * 4 is not received,
     * it waits until it is called
     * working is not displayed after the reference
     * is created
     */

    /**
     * LIVE DATA
     * 1 - Observability
     * 2 - Life Cycle Awareness

     */
    private val _counter = MutableLiveData<Int>()
    val counter : LiveData<Int>
        get() = _counter
    val counterString = Transformations.map(counter) {
        it.toString()
    }

    init {
        _counter.value = 0
        Log.e("ViewModel", "View Model is created")
    }

    fun clickMeButtonClicked(){
        _counter.value = _counter.value?.plus(1)
    }

    fun addTenButtonClicked(){
        _counter.value = _counter.value?.plus(10)
    }


    /**
     * fun counter() : String {
     * return counter.toString()
     * }
     *
     * SHORTER SYNTAX
     * KOTLIN TYPE INFERENCE YAPABILDIĞI İÇİN
     * RETURN DEĞERİNİ YAZMAMIZA GEREK KALMIYOR
     *
     * fun counter() = counter.toString()
     */

    override fun onCleared() {
        super.onCleared()
        Log.e("ViewModel", "View Model cleared.")
    }
}