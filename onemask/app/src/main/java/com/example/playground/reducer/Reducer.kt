package com.example.playground.reducer

import com.example.playground.action.Action
import com.example.playground.action.CounterActions
import com.example.playground.state.CounterState

typealias Reducer<S> = (S, Action) -> S

val CounterStateReducer: Reducer<CounterState> = { old, action ->
    when (action) {
        is CounterActions.Init -> CounterState()
        is CounterActions.Increment -> old.copy(value = old.value + 1)
        is CounterActions.Decrement -> old.copy(value = old.value - 1)
        else -> old
    }
}
