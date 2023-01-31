package com.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.databinding.ItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    //val list = mutableListOf<ListModel>()
    var items = ArrayList<Genres>()
    fun setUpdateData(items : ArrayList<Genres>){
        this.items = items
        notifyDataSetChanged()
    }
    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.tvTitle.text = items[position].name
        }
    }
    override fun getItemCount(): Int = items.size
}