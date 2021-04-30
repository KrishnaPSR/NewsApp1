package com.example.mynews2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mynews2.R
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val bundle=intent
        val heading =   bundle.getStringExtra("newsTitile")
        val description =  bundle.getStringExtra("newsDesc")
        val image = bundle.getStringExtra("image")
        val author = bundle.getStringExtra("author")

        Glide.with(this)
            .load(image)
            .placeholder(R.drawable.no_image_available)
            .into(ivImage)
        tvHeading.text = heading
        tvAuthor.text = author
        tvDescription.text = description

    }
}