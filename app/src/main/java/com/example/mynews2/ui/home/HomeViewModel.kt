package com.example.mynews2.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mynews2.db.RoomDbBuilder
import com.example.mynews2.db.SavedNews
import java.util.concurrent.Executors

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    var savedData: LiveData<List<SavedNews>> = MutableLiveData()
    private val roomDbBuilder = RoomDbBuilder.getInstance(context)

    fun addSavedNewsDetails(savedNews: SavedNews) {
        Executors.newSingleThreadExecutor().execute {
            roomDbBuilder.savedNewsDao().insertNews(
                SavedNews(
                    news_title = savedNews.news_title,
                    news_desc = savedNews.news_desc,
                    news_time = savedNews.news_time
                )
            )
        }
    }
    init {
        // to getAllUserDetails()
        savedData = roomDbBuilder.savedNewsDao().getAllNews()

    }
}