package com.example.mynews2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynews2.R
import com.example.mynews2.db.SavedNews
import com.example.mynews2.ui.newsview.NewsViewFragment

class SaveAdapter(private val context: NewsViewFragment, private val newsDataset: ArrayList<SavedNews>): RecyclerView.Adapter<SaveAdapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val savedNewsTitle: TextView = view.findViewById(R.id.savedNewsTitleTV)
        val savedNewsDescription: TextView = view.findViewById(R.id.savedNewsDescriptionTV)
        val savedNewsTime: TextView = view.findViewById(R.id.savedNewsPublishedTimeTV)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.saved_news_item,parent,false)
        return ViewHolder(inflater)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            savedNewsTitle.text = newsDataset[position].news_title
            savedNewsDescription.text = newsDataset[position].news_desc
            savedNewsTime.text = newsDataset[position].news_time
        }
    }
    override fun getItemCount(): Int = newsDataset.size
}