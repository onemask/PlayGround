package com.example.playground.state


//Redux 는 단방향 데이터 흐름이다.
data class CounterState (
    val value : Int = 0
) : State

//state - 앱이 작동하도록 전체 데이터 및 값으로 정의됩니다.
interface State {
}