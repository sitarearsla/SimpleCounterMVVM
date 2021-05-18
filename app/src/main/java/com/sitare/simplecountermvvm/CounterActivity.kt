package com.sitare.simplecountermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class CounterActivity : AppCompatActivity() {

    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val clickMeButton = findViewById<Button>(R.id.button)
        val addTenButton = findViewById<Button>(R.id.addTen)
        val counterTextView = findViewById<TextView>(R.id.textView)

        viewModel.counterString.observe(this){ newCounter ->
            counterTextView.text = newCounter
        }

        clickMeButton.setOnClickListener {
            viewModel.clickMeButtonClicked()
        }

        addTenButton.setOnClickListener {
            viewModel.addTenButtonClicked()
        }

        Log.e("Activity", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Activity", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("Activity", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Activity", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Activity", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Activity", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Activity", "onDestroy")
    }
}