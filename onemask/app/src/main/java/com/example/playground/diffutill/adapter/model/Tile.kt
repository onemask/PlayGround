package com.example.playground.diffutill.adapter.model

import android.graphics.Color


data class Tile(val number: Int) {
    val color: Int =
        if (number < 100) Color.BLACK + (TWO_TO_EIGHT * TWO_TO_EIGHT * TWO_TO_EIGHT * number * (100 - number) / 25) / (100)
        else Color.WHITE

    override fun equals(other: Any?): Boolean {
        (other as? Tile)?.let {
            return this.number == it.number
        } ?: return super.equals(other)
    }

    companion object {
        const val TWO_TO_EIGHT: Int = 256
    }

}



