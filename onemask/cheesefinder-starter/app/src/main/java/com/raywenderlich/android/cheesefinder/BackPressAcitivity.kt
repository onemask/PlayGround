package com.raywenderlich.android.cheesefinder

import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_back_press_acitivity.*

class BackPressAcitivity : BaseSearchActivity() {

    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_press_acitivity)
    }

    override fun onStart() {
        super.onStart()
        testBackBtn()
    }

    private fun testBackBtn() {
        bt_disable_back.setOnClickListener {
            button = bt_disable_back
            onBackPressed()

        }

        bt_ensable_back.setOnClickListener {
            button = bt_ensable_back
            onBackPressed()
        }
    }


    override fun onBackPressed() {

        when (this.button?.id) {
            bt_disable_back.id -> {
            }
            bt_ensable_back.id -> {
                super.onBackPressed()

            }
        }


    }

}
