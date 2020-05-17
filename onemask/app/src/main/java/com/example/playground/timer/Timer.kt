package com.example.playground.timer

import android.os.Build
import androidx.annotation.RequiresApi
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import java.time.LocalDateTime
import java.util.concurrent.TimeUnit

class Timer {

    //TODO("TIMber 테스트 중임 ")

    fun tictok(n: Long) {
        Observable.timer(1000, TimeUnit.MILLISECONDS)
            .subscribe({
                it==0L
                println("after ${LocalDateTime.now()} ")
            }, {
                Timber.e("${it.printStackTrace()}")
            })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    println("now TIme ${LocalDateTime.now()} and ${Timer().tictok(3000).toString()}")
}