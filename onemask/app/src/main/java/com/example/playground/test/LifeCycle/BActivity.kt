package com.example.playground.test.LifeCycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.playground.R
import timber.log.Timber

class BActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Timber.d("BActivity : onCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.d("BActivity : onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("BActivity : onResume")

    }

    override fun onPause() {
        super.onPause()
        Timber.d("BActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("BActivity : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("BActivity : onDestroy")
    }
}