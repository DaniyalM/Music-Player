package com.example.design.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "songs_table")
data class Song(
    val mediaId:String="",
    val title:String="",
    val subtitle:String="",
    val songUrl:String="",
    val imageUrl:String=""
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}