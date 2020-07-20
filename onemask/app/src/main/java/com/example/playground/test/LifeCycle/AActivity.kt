package com.example.playground.test.LifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playground.R

class AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }
}