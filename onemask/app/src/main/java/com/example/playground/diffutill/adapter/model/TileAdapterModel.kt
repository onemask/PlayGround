package com.example.playground.diffutill.adapter.model

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class TileAdapterModel(private val adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {

    private val tiles = mutableListOf<Tile>()

    init {
        tiles.clear()
        (1..TILE_SIZE).forEach {
            tiles.add(Tile(it))
        }
    }

    fun size(): Int = tiles.size

    fun get(position: Int) = tiles[position]

    private fun calDiff(newTiles: MutableList<Tile>) {
        val tileDiffUtilCallback = TileDiffUtilCallback(tiles, newTiles)
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(tileDiffUtilCallback)
        diffResult.dispatchUpdatesTo(adapter)
    }

    private fun setNewTiles(newTiles: MutableList<Tile>) {
        tiles.clear()
        tiles.addAll(newTiles)
    }

    fun shuffle() {
        val newTiles = mutableListOf<Tile>()
        newTiles.addAll(tiles)
        newTiles.shuffle()
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun eraseOneTile() {
        val newTiles = mutableListOf<Tile>()
        tiles.isNotEmpty().let {
            val erasedRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
            tiles.forEachIndexed { index, tile ->
                if (index != erasedRandomIdx) newTiles.add(tile)
            }
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun addOneTile() {
        val newTiles = mutableListOf<Tile>()
        newTiles.addAll(tiles)

        val insertRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
        newTiles.add(insertRandomIdx, Tile(tiles.size + 1))

        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun eraseThreeTile() {
        val newTiles = mutableListOf<Tile>()
        tiles.isNotEmpty().let {
            repeat(3) {
                val erasedRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
                newTiles.removeAt(erasedRandomIdx)

            }
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    fun addThreeTile() {
        val newTiles = mutableListOf<Tile>()
        newTiles.addAll(tiles)
        repeat(3){
            val insertRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
            newTiles.add(insertRandomIdx, Tile(tiles.size + 1))
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }

    inner class TileDiffUtilCallback(
        private val oldTiles: MutableList<Tile>,
        private val newTiles: MutableList<Tile>
    ) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldTiles[oldItemPosition] == newTiles[newItemPosition]
        }

        override fun getOldListSize(): Int {
            return oldTiles.size
        }

        override fun getNewListSize(): Int {
            return newTiles.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldTiles[oldItemPosition].number == newTiles[newItemPosition].number
        }
    }

    companion object {
        const val TILE_SIZE = 25
    }

}