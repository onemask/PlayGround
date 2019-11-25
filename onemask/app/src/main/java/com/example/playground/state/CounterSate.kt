package com.example.playground.state


//Redux 는 단방향 데이터 흐름이다.
data class CounterState (
    val value : Int = 0
) : State