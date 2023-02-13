package com.example.islami_kotlin.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_kotlin.databinding.ItemHadethBinding

class HadethAdapter(val items: List<Hadeth>):RecyclerView.Adapter<HadethAdapter.ViewHolder>() {
    class ViewHolder(val viewBinding: ItemHadethBinding): RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(viewBinding)
    }
    var onItemHClick:OnItemHClick ?=null
    interface OnItemHClick{
        fun onHadethNameClick(hadeth: Hadeth, position:Int)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.hadethNameTitle.text= items[position].title
        holder.viewBinding.hadethNameTitle.setOnClickListener {
            onItemHClick?.onHadethNameClick( items.get(position), position)
        }
    }

    override fun getItemCount(): Int =items.size

}