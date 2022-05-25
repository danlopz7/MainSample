package com.example.data.di

import android.content.Context
import com.example.data.database.PhotosDataBase
import com.example.data.database.dao.PhotosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePhotoDatabase(@ApplicationContext context: Context): PhotosDataBase {
        return PhotosDataBase.getDatabase(context)
    }

    @Provides
    fun providePhotoDao(appDatabase: PhotosDataBase): PhotosDao {
        return appDatabase.photosDao
    }


}