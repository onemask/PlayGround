package com.example.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.playground.action.CounterActions
import com.example.playground.di.DI
import com.example.playground.state.CounterState

class MainActivity : AppCompatActivity() {

    private val decrementButton by lazy { findViewById<Button>(R.id.decrement_button) }
    private val incrementButton by lazy { findViewById<Button>(R.id.increment_button) }
    private val counterText by lazy { findViewById<TextView>(R.id.counter_text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DI.store.add {
            counterText.text ="${it.value}"
        }

        DI.store.dispatch(action = CounterActions.Init)

        decrementButton.setOnClickListener {
            DI.store.dispatch(action =  CounterActions.Decrement)
        }

        incrementButton.setOnClickListener {
            DI.store.dispatch(action =  CounterActions.Increment)
        }

    }
}
