package com.example.playground

import com.example.playground.action.CounterActions
import com.example.playground.reducer.CounterStateReducer
import com.example.playground.state.CounterState
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_CounterState(){
        //given
        val old = CounterState(value = 3)
        val action = CounterActions.Increment

        //when
        val new = CounterStateReducer(old,action)


        assertEquals(CounterState(value = 4),new)
    }
}
