package com.example.playground.store

import com.example.playground.action.Action
import com.example.playground.state.State


typealias StoreSubscriber <S> = (S) -> Unit

interface Store<S : State> {
    fun dispatch(action: Action)
    fun add(subscriber: StoreSubscriber<S>): Boolean
    fun remove(subscriber: StoreSubscriber<S>): Boolean
    fun getCurrent() : S
}



