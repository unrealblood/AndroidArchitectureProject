package com.strength.androidarchitectureproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.strength.androidarchitectureproject.viewmodels.MainViewModel
import com.strength.androidarchitectureproject.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity(), LifecycleOwner {
    init {
        lifecycle.addObserver(MyLifecycleObserver())
    }

    private lateinit var numberTextView : TextView
    private lateinit var increaseButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberTextView = findViewById(R.id.number_text_view_MA)
        increaseButton = findViewById(R.id.increment_button_MA)

        val mainViewModel = ViewModelProvider(this, MainViewModelFactory(10)).get(MainViewModel::class.java)

        updateNumberTextView(numberTextView, mainViewModel)

        increaseButton.setOnClickListener {
            mainViewModel.incrementNumberX()
            updateNumberTextView(numberTextView, mainViewModel)
        }
    }

    private fun updateNumberTextView(textView : TextView, mainViewModel: MainViewModel) {
        textView.text = mainViewModel.numberX.toString()
    }
}