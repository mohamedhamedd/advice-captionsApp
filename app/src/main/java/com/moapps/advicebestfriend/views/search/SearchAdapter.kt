package com.moapps.advicebestfriend.views.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moapps.advicebestfriend.R
import com.moapps.advicebestfriend.pojo.SlipX

class SearchAdapter(var context: Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private lateinit var items: List<SlipX>

    fun setData(mItems: List<SlipX>) {
        items = mItems
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_search, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val results = items[position]
        holder.mText?.text = results.advice
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mText = itemView.findViewById<TextView>(R.id.row_advice_text)
    }

}