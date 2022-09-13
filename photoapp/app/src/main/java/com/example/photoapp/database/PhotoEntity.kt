package com.example.photoapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    var photoId:Int,
    var imageDrawable:Int,
    var ratingStar: Float,
    var reviewText:String
) {

}