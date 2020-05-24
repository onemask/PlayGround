/*
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
    //size 26
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

    private fun eraseOneTile() {
        val newTiles = mutableListOf<Tile>()
        tiles.isNotEmpty().let {
            val erasedRandomIdx = (Random.nextDouble() * newTiles.size).toInt()//0
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
//idx 7 number 7
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
        repeat(3) {
            val insertRandomIdx = (Random.nextDouble() * newTiles.size).toInt()
            newTiles.add(insertRandomIdx, Tile(tiles.size + 1))
        }
        calDiff(newTiles)
        setNewTiles(newTiles)
    }


    companion object {
        const val TILE_SIZE = 25
    }

}*/
