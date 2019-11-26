package com.example.playground.store

import com.example.playground.action.Action
import com.example.playground.reducer.Reducer
import com.example.playground.state.State

class DefaultStore<S : State>(initialState: S, private val reducer: Reducer<S>) : Store<S> {

    private var state: S = initialState
        set(value) {
            //update state
            field = value
            //notify all subscribers
            subscribers.forEach {
                it(value)
            }
        }

    private val subscribers = mutableSetOf<StoreSubscriber<S>>()

    override fun dispatch(action: Action) {
        state = reducer(state, action)
    }

    override fun add(subscriber: StoreSubscriber<S>): Boolean = subscribers.add(subscriber)

    override fun remove(subscriber: StoreSubscriber<S>): Boolean = subscribers.remove(subscriber)

    override fun getCurrent(): S = state

}