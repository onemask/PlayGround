package com.example.playground

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.action.CounterActions
import com.example.playground.di.DI
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val decrementButton by lazy { findViewById<Button>(R.id.decrement_button) }
    private val incrementButton by lazy { findViewById<Button>(R.id.increment_button) }
    private val counterText by lazy { findViewById<TextView>(R.id.counter_text_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DI.store.add {
            counterText.text = "${it.value}"
        }

        DI.store.dispatch(action = CounterActions.Init)

        decrementButton.setOnClickListener {
            DI.store.dispatch(action = CounterActions.Decrement)
        }

        incrementButton.setOnClickListener {
            DI.store.dispatch(action = CounterActions.Increment)
        }

        btn_google_login.setOnClickListener {

        }

        /*
         * foldRight & fold
         */
        val list = listOf(1, 2, 3, 4, 5)
        val sumTotal = list.foldRight(list.first(), { total, next ->
            println("total $total newxt $next")
            total + next
        })
        println("sumTotal $sumTotal")

        println("fold \n")
        val sumLeftTotal = list.fold(0, { total, next ->
            println("total $total newxt $next")
            total + next
        })
        println("sumLeftTotal $sumLeftTotal")



        data class Fruit(
            val price: Int,
            val name: String
        )

        /*
        * foldRightIndexed & foldIndexed
        */
        val objectLlist =
            listOf(
                Fruit(100, "apple"),
                Fruit(200, "pineapple"),
                Fruit(500, "watermelon")
            )

        println("foldRightIndexed \n")
        val fruitList = objectLlist.foldRightIndexed(0, { index, fruitPrice, next ->
            println("\n index $index fruitPrice $fruitPrice next $next ")
            fruitPrice.price + next
        })
        println("fruitList $fruitList")


        println("foldIndex \n")
        val fruitLeftList =
            objectLlist.foldIndexed(objectLlist.first().name, { index, fruitName, next ->
                println("\n index $index fruitName $fruitName next $next ")
                fruitName + " " + next.name
            })
        println("fruitLeftList $fruitLeftList")


    }
}
