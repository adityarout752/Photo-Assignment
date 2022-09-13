package com.example.photoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.photoapp.database.PhotoDB
import com.example.photoapp.database.PhotoEntity
import com.example.photoapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    val repository: Repository
    var photoDataOffline: LiveData<List<PhotoEntity>>

    init {
        val dao = PhotoDB.getDatabase(application).photoDao()
        repository = Repository(dao)
        photoDataOffline = repository.allPhotoData
    }

    fun insertData(photoEntity: PhotoEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(photoEntity)
    }

    fun updateData(photoEntity: PhotoEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(photoEntity)
    }

}