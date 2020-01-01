package com.example.playground.sampleSpinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.playground.R
import kotlinx.android.synthetic.main.activity_sample_spinner.*
import java.util.*

class SampleSpinnerActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_spinner)
        setupSpinnerAdapter()

    }

    private fun setupSpinnerAdapter() {

        ArrayAdapter.createFromResource(
            this,
            R.array.rainbow,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }



        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parent?.getItemAtPosition(position)
                Log.d("selected Item Pos", "$position")
                Toast.makeText(applicationContext, "position $position", Toast.LENGTH_LONG).show()
            }

        }
    }


}
