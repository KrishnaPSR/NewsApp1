package com.example.mynews2.db

import android.content.Context
import androidx.room.Room

object RoomDbBuilder {

    //to create Instance
    private var INSTANCE: AppDb? = null
    fun getInstance(context: Context): AppDb {
        /*
        to check the existence of database
         */
        if (INSTANCE == null) {
            synchronized(AppDb::class) {
                INSTANCE = createRoomDb(context)
            }
        }
        return INSTANCE!!
    }
    /*
    function to Create Database
     */
    private fun createRoomDb(context: Context): AppDb? {
        return Room.databaseBuilder(context, AppDb::class.java, "Saved News Entity")
            .fallbackToDestructiveMigration()
            .build()
    }
}