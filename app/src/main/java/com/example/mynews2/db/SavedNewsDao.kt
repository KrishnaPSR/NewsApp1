package com.example.mynews2.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynews2.db.SavedNews

@Dao
interface SavedNewsDao {

    @Query("Select * from News_table")
    fun getAllNews(): LiveData<List<SavedNews>>

    @Insert
    fun insertNews(savedNews: SavedNews)
}