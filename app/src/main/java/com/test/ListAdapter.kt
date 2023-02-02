package com.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.databinding.ItemBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    //val list = mutableListOf<ListModel>()
    //khởi tạo GenresModel
    var genres = mutableListOf<Genres>()
    fun setUpdateData(genres : ArrayList<Genres>){
        this.genres = genres
        notifyDataSetChanged()
    }
    private val diffUtilCallBack = object : DiffUtil.ItemCallback<Genres>(){
        override fun areItemsTheSame(oldItem: Genres, newItem: Genres): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Genres, newItem: Genres): Boolean {
            return oldItem == newItem
        }
    }
    val diffGenres = AsyncListDiffer(this,diffUtilCallBack)
    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //xác định giao diện  người dùng
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            //nhận dữ liệu để hiển thị lên UI
            binding.item = diffGenres.currentList[position]
            //tránh sử dụng lại các viewItem cũ/bị ẩn
            setIsRecyclable(false)
        }
    }
    //kích thước của model
    override fun getItemCount(): Int = diffGenres.currentList.size

}