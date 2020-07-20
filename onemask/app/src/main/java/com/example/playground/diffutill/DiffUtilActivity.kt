package com.example.playground.diffutill

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.playground.R
import com.example.playground.diffutill.adapter.DiffUtilAdapter
import kotlinx.android.synthetic.main.activity_diff_utill.*
import java.net.HttpURLConnection
import java.net.URL

class DiffUtilActivity : AppCompatActivity() {

    private val madapter by lazy { DiffUtilAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_utill)
        //setupAdatper()
        //setupButton()
        connect()
    }

    private fun connect() {
        try {
            val url = URL("https://google.co.kr")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "GET"
            conn.doOutput = true
            conn.doInput = true
            conn.useCaches = false
            conn.defaultUseCaches = false

            val result = conn.inputStream.bufferedReader().use {
                it.readText()
            }
            print("result $result")
        }catch (exception: Exception) {
            println("e $exception")
        }

    }

    private fun setupAdatper() {
        madapter.setItems(10)

        main_recycler_view.run {
            adapter = madapter
            layoutManager = GridLayoutManager(applicationContext, 5)
            setHasFixedSize(true)
        }
    }

    private fun setupButton(){
        shuffle_button.setOnClickListener {
            madapter.shuffle()
        }

        erase_button.setOnClickListener {
            madapter.eraseOneTile()
        }

        add_button.setOnClickListener {
            madapter.addOneTile()
        }

        three_erase_button.setOnClickListener {
            madapter.eraseThreeTile()
        }

        three_add_button.setOnClickListener {
            madapter.addThreeTile()
        }

    }
}
