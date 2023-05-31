package com.strength.androidarchitectureproject.viewmodels

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var numberX = 0

    fun incrementNumberX() {
        numberX++
    }
}