package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var counter = MutableLiveData<Int>(5)


    fun add() {
        counter.value = counter.value?.plus(1)
    }
}


