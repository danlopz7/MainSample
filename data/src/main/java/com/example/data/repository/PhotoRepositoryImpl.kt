package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.data.database.dao.PhotosDao
import com.example.data.database.model.asDomainModel
import com.example.data.networking.PhotosApi
import com.example.data.networking.model.asDatabaseModel
import com.example.domain.model.Photos
import com.example.domain.repository.PhotoRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotoRepositoryImpl @Inject constructor(
    private val photosApi: PhotosApi,
    private val photosDao: PhotosDao
) : PhotoRepository {

    override suspend fun getAllPhotos(): LiveData<List<Photos>> {
        return Transformations.map(photosDao.getPhotos()) {
            it.asDomainModel()
        }
    }
    override suspend fun refreshPhotos() {
        withContext(Dispatchers.IO) {
            val posts = photosApi.getPhotos()
            photosDao.insertAll(posts.asDatabaseModel())
        }
    }
}
