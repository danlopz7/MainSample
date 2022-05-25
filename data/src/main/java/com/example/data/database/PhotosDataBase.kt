package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.database.dao.PhotosDao
import com.example.data.database.model.PhotosEntity

@Database(entities = [PhotosEntity::class], version = 1, exportSchema = false)

abstract class PhotosDataBase : RoomDatabase(){

    abstract val photosDao: PhotosDao


    companion object{

        private lateinit var INSTANCE: PhotosDataBase

        fun getDatabase(context: Context): PhotosDataBase {
            synchronized(PhotosDataBase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        PhotosDataBase::class.java,
                        "Photos-DDBB").build()
                }
            }
            return INSTANCE
        }
    }
}