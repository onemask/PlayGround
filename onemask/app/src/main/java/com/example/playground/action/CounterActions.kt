package com.example.playground.action

sealed class CounterActions : Action {
    object Init : CounterActions()
    object Increment : CounterActions()
    object decrement : CounterActions()
}

interface Action {}