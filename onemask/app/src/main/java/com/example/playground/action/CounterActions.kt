package com.example.playground.action

sealed class CounterActions : Action {
    object Init : CounterActions()
    object Increment : CounterActions()
    object Decrement : CounterActions()
}

interface Action {}