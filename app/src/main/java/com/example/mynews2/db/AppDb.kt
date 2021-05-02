package com.example.mynews2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mynews2.db.SavedNews

@Database(entities = [SavedNews::class] , version = 1)
abstract class AppDb: RoomDatabase() {
    abstract fun savedNewsDao(): SavedNewsDao
}