package com.example.mynews2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDAO
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBooks(book: NewsEntity)

    @Query(value = "Select * from NewsEntity")
    fun getAllBooks() : List<NewsEntity>
}