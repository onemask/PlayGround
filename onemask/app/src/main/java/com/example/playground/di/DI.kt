package com.example.playground.di

import com.example.playground.reducer.CounterStateReducer
import com.example.playground.state.CounterState
import com.example.playground.store.DefaultStore

object DI {
    val store = DefaultStore(initialState = CounterState(), reducer = CounterStateReducer)
}