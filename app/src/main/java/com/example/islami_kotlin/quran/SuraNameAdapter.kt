package com.example.islami_kotlin.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_kotlin.R

class SuraNameAdapter (val items:List<String>) :RecyclerView.Adapter<SuraNameAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val  suraNameTV :TextView
        init {
            suraNameTV = itemView.findViewById(R.id.suraNameTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quran, parent, false)
        return ViewHolder(view)
    }
    var onItemClick:OnItemClick ?=null
    interface OnItemClick{
        fun onSuraNameClick(sura: String , position:Int)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     holder.suraNameTV.text=items[position]
        holder.itemView.setOnClickListener{ onItemClick?.onSuraNameClick(items.get(position), position)
        }
    }

    override fun getItemCount(): Int = items.size
}