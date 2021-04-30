package com.example.mynews2.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynews2.activity.NewsActivity
import com.example.mynews2.R
import com.example.mynews2.model.DataModel

class ItemAdapter(private val context: Context, private val dataList : List<DataModel>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(view : View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.newsTitleTV)
        val desc: TextView = view.findViewById(R.id.newsDescriptionTV)
        val image: ImageView = view.findViewById(R.id.imageView)
        val newsView: CardView = view.findViewById(R.id.cvNews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            title.text = dataList[position].title
            desc.text = dataList[position].description

            Glide.with(context)
                .load(dataList[position].image)
                .placeholder(R.drawable.no_image_available)
                .into(image)

            newsView.setOnClickListener{
                val intent= Intent(context, NewsActivity::class.java)
                intent.putExtra("newsTitile",dataList[position].title)
                intent.putExtra("newsDesc",dataList[position].description)
                intent.putExtra("image",dataList[position].image)
                intent.putExtra("author",dataList[position].author)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size
}