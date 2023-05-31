package com.strength.androidarchitectureproject.viewmodels

import androidx.lifecycle.ViewModel

class MainViewModel(val defaultNumberX : Int) : ViewModel() {
    var numberX = defaultNumberX

    fun incrementNumberX() {
        numberX++
    }
}