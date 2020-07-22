package com.example.playground.test.LifeCycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.R
import kotlinx.android.synthetic.main.activity_a.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class AActivity : AppCompatActivity() {
    var currentIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Timber.d("AActivity : onCreate")
        setUpButton()
    }

    override fun onStart() {
        super.onStart()
        Timber.d("AActivity : onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("AActivity : onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.d("AActivity onRestart")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("AActivity : onPause")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("AActivity : onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("AActivity : onDestroy")
    }

    private fun setUpButton() {
        //For LifeCycle Test
        /* to_b.setOnClickListener {
        val intent = Intent(this, BActivity::class.java)
        startActivity(intent)
        }*/
        to_b.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                val job = launch(Dispatchers.Main) {
                    10.countDown(currentIndex)
                }
                job.join()
            }
        }
    }

    private suspend fun Int.countDown(currentIndex: Int) {
        for (index in this downTo 1) {
            tv_description.text = "Now index $currentIndex CountDown $index"
            delay(200)
        }
        Timber.d("Now index $currentIndex Done")
    }
}