package com.example.mynews2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews2.R
import com.example.mynews2.adapter.ItemAdapter
import com.example.mynews2.adapter.SaveAdapter
import com.example.mynews2.db.NewsEntity
import com.example.mynews2.model.DataModel
import kotlinx.android.synthetic.main.activity_main.*

class SaveActivity : AppCompatActivity() {
    var newsList =  ArrayList<NewsEntity>()
    private lateinit var itemAdapter: SaveAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)
        setupUI()
    }
    private fun setupUI() {
        //recycler view
        val layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager

        //attaching adapter to recycler view
        itemAdapter = SaveAdapter(this,newsList)
        recyclerView.adapter = itemAdapter
    }
}