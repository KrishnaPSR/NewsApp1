package com.example.mynews2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class NewsEntity {

  @PrimaryKey
   var bookId: Int =0

    @ColumnInfo(name ="Heading")
    var heading:  String =""

    @ColumnInfo(name ="Description")
    var description:  String =""

    @ColumnInfo(name ="Image")
    var image:  String =""

    @ColumnInfo(name ="Author")
    var author:  String =""

}
