package com.example.domain.repository

import androidx.lifecycle.LiveData
import com.example.domain.model.Photos


interface PhotoRepository {

    suspend fun getAllPhotos(): LiveData<List<Photos>>

    suspend fun refreshPhotos(): Unit

}