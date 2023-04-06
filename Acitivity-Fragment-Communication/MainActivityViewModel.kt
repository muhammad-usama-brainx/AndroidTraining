package com.example.firstapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var number = 0;

    fun increaseNumber() {
        number++;
    }
}