package com.dev.android.paging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.android.paging.R
import com.dev.android.paging.models.Result


class QuotePagerAdapter : PagingDataAdapter<Result,QuotePagerAdapter.QuoteViewHolder>(COMPARATOR){

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) {
            holder.quote.text = item.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote,parent,false)
        return QuoteViewHolder(view)
    }


    class QuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val quote : TextView = itemView.findViewById(R.id.quote)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }




}