package com.example.zelda_pedia.adapters

import android.annotation.SuppressLint
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zelda_pedia.R
import com.example.zelda_pedia.models.games.Data
import java.util.Collections.addAll

class GameAdapter() : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    private val gameList = mutableListOf<Data>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = gameList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtGameTitle.text = gameList[position].name
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addList(newData: List<Data>) {
        gameList.apply {
            clear()
            addAll(newData)
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtGameTitle: TextView
        fun bind(item: Data, listener: Listener?) {

        }
        init {
            txtGameTitle = view.findViewById(R.id.txt_game_title)
        }
    }

    interface Listener {
        fun onClickItemListener(item: Data)
    }

}