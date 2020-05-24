package com.example.playground.diffutill.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.playground.R
import com.example.playground.diffutill.adapter.model.Tile
import kotlinx.android.synthetic.main.item_tile.view.*
import kotlin.random.Random

class DiffUtilAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet = mutableListOf<Tile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TileViewHolder(parent)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TileViewHolder).bind(dataSet[position])
    }

    private fun setNewTiles(newTiles: MutableList<Tile>) {
        dataSet.run {
            clear()
            addAll(newTiles)
        }
    }

    private fun calDiff(newTiles: MutableList<Tile>) {
        val tileDiffUtilCallback = TileDiffUtilCallback(dataSet, newTiles)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(tileDiffUtilCallback)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setItems(num: Int) {
        dataSet.clear()
        (1..num).forEach {
            dataSet.add(Tile(it))
        }
    }

    fun shuffle() {
        val newTiles = mutableListOf<Tile>().apply {
            addAll(dataSet)
            shuffle()
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun addOneTile() {
        val newTiles = mutableListOf<Tile>().apply {
            addAll(dataSet)
        }
        val insertRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
        newTiles.add(insertRandomIdx, Tile(dataSet.size + 1))
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun eraseOneTile() {
        val newTiles = mutableListOf<Tile>()
        dataSet.isNotEmpty().let {
            val erasedRandomIdx = (Random.nextDouble() * newTiles.size).toInt()//0
            dataSet.forEachIndexed { index, tile ->
                if (index != erasedRandomIdx) newTiles.add(tile)
            }
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }


    fun eraseThreeTile() {
        val newTiles = mutableListOf<Tile>().apply {
            addAll(dataSet)
        }
        repeat(3) {
            val erasedRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
            newTiles.removeAt(erasedRandomIdx)
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun addThreeTile() {
        val newTiles = mutableListOf<Tile>()
        newTiles.addAll(dataSet)
        repeat(3) {
            val insertRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
            newTiles.add(insertRandomIdx, Tile(newTiles.size + 1))
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    inner class TileViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_tile, parent, false)
    ) {
        fun bind(tile: Tile) {
            itemView.run {
                number_text_view.text = tile.number.toString()
                background_view.setBackgroundColor(tile.color)
            }
        }
    }

}

class TileDiffUtilCallback(
    private val oldTiles: List<Tile>,
    private val newTiles: List<Tile>
) : DiffUtil.Callback() {
    //두 객체가 같은 항목인지 여부를 결정
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTiles[oldItemPosition] == newTiles[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldTiles.size
    }

    override fun getNewListSize(): Int {
        return newTiles.size
    }

    //aleItemsTheSame 이 true 일때만 나옴.
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldTiles[oldItemPosition].number == newTiles[newItemPosition].number
    }
}

