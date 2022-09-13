package com.example.photoapp.repository

import androidx.lifecycle.LiveData
import com.example.photoapp.database.PhotoDao
import com.example.photoapp.database.PhotoEntity

class Repository(val photoDao: PhotoDao) {


    suspend fun insert(photoEntity: PhotoEntity) {
        photoDao.insertPhotoDetails(photoEntity)
    }

    suspend fun update(photoEntity: PhotoEntity) {
        photoDao.updatePhotoDetails(photoEntity)
    }


    val allPhotoData: LiveData<List<PhotoEntity>> = photoDao.getAllPhotos()


}