package com.example.zelda_pedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zelda_pedia.R
import com.example.zelda_pedia.models.games.Data

class GameAdapter : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    private val gameList = mutableListOf<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = gameList[position].name
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView
        fun bind(item: Data, listener: Listener?) {

        }
        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.txt_game_title)
        }
    }

    interface Listener {
        fun onClickItemListener(item: Data)
    }

}