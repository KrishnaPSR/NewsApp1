package com.example.mynews2.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mynews2.R
import com.example.mynews2.extensions.showToast

class WebActivity : AppCompatActivity() {
    private val sharedPrefFileName = "NewsSharedPreferences"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFileName , Context.MODE_PRIVATE)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        /*
        to receive news url by clicking on news item
         */
        val urlNews = intent.getStringExtra("url_news")
        val titleNews = intent.getStringExtra("title_news")
        val descNews = intent.getStringExtra("desc_news")
        val timeNews = intent.getStringExtra("time_news")
        showToast("title news variable is $titleNews")//  show toast is an extension function here
        /**
        editor is Interface used for modifying values in a SharedPreferences object.
        All changes you make in an editor are batched, and not copied back to the original SharedPreferences
        until you call commit or apply
         ***/
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("news_url_key" , urlNews)
        editor.putString("news_title_key" , titleNews)
        editor.putString("news_desc_key" , descNews)
        editor.putString("news_time_key" , timeNews)
        editor.apply()
        editor.commit() //to commit the changes

        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_home, R.id.navigation_newsView, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}