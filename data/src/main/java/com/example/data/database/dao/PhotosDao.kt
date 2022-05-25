package com.example.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.model.PhotosEntity

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photosEntity")
    fun getPhotos(): LiveData<List<PhotosEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(photos: List<PhotosEntity>)


}