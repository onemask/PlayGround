package com.example.playground.diffutill.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.playground.R
import com.example.playground.diffutill.adapter.model.Tile
import com.example.playground.diffutill.adapter.model.TileAdapterModel
import kotlinx.android.synthetic.main.item_tile.view.*

class DiffUtilAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dataSet = TileAdapterModel(this)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TileViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return dataSet.size()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TileViewHolder).bind(dataSet.get(position))
    }

    fun shuffle() = dataSet.shuffle()

    fun eraseOneTile() = dataSet.eraseOneTile()

    fun addOneTile() = dataSet.addOneTile()

    fun eraseThreeTile() = dataSet.eraseThreeTile()

    fun addThreeTile() = dataSet.addThreeTile()

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

