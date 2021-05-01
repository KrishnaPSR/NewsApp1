package com.example.mynews2.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [(NewsEntity::class)],version = 1)
abstract class AppDb : RoomDatabase() {

    abstract fun bookDao(): BookDAO
}