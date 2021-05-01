package com.example.mynews2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.mynews2.R
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        saveButton.setOnClickListener(View.OnClickListener {
            //intent= Intent(this,SaveActivity::class.java)
            Toast.makeText(this,"News Saved",Toast.LENGTH_LONG).show()
        })
        viewNewsButton.setOnClickListener(View.OnClickListener {
            //intent=Intent(this,SaveActivity::class.java)
            startActivity(Intent(this,SaveActivity::class.java))

        })

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