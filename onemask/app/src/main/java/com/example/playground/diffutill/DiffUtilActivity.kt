package com.example.playground.diffutill

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.playground.R
import com.example.playground.diffutill.adapter.DiffUtilAdapter
import kotlinx.android.synthetic.main.activity_diff_utill.*

class DiffUtilActivity : AppCompatActivity() {

    private val madapter by lazy { DiffUtilAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_utill)
        setupAdatper()
        setupButton()
    }

    private fun setupAdatper() {
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
