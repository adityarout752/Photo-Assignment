package com.example.photoapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotoDetails(photoEntity: PhotoEntity)

    @Update
    suspend fun updatePhotoDetails(photoEntity: PhotoEntity)

    @Query("Select * From photo_table  ")
    fun getAllPhotos(): LiveData<List<PhotoEntity>>
}