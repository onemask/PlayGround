package com.example.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.playground.state.CounterState

class MainActivity : AppCompatActivity() {

    private val decrementButton by lazy { findViewById<Button>(R.id.decrement_button) }
    private val incrementButton by lazy { findViewById<Button>(R.id.increment_button) }
    private val counterText by lazy { findViewById<TextView>(R.id.counter_text_view) }

    private var state = CounterState()
    set(value) {
        field = value
        counterText.text = "${state.value}"
    }
    //For Counting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton.setOnClickListener {
            state = state.copy(value = state.value-1)
        }

        incrementButton.setOnClickListener {
            state = state.copy(value = state.value+1)

        }
    }
}
