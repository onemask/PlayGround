package com.example.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val decremetnButton by lazy { findViewById<Button>(R.id.decrement_button) }
    private val incrementButton by lazy { findViewById<Button>(R.id.increment_button) }
    private val counterText by lazy { findViewById<Button>(R.id.counter_text_view) }

    //For Counting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decremetnButton.setOnClickListener {

        }

        incrementButton.setOnClickListener {

        }
    }
}
