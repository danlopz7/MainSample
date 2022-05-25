package com.example.data.di


import com.example.data.database.dao.PhotosDao
import com.example.data.networking.PhotosApi
import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {


    @Provides
    fun providePhotoRepository(photoAPi: PhotosApi, photosDao: PhotosDao): PhotoRepository {
        return PhotoRepositoryImpl(photoAPi, photosDao)
    }
}