package com.sitare.simplecountermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class CounterActivity : AppCompatActivity() {

    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val clickMeButton = findViewById<Button>(R.id.button)
        val counterTextView = findViewById<TextView>(R.id.textView)

        counterTextView.text = viewModel.counter()

        clickMeButton.setOnClickListener {
            viewModel.incrementCounter()
            counterTextView.text = viewModel.counter()
        }
    }
}