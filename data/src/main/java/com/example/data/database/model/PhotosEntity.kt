package com.example.data.database.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Photos

@Entity
data class PhotosEntity(
    @NonNull @ColumnInfo(name = "albumId")val albumId: Int,
    @PrimaryKey val id: Int,
    @NonNull @ColumnInfo(name = "title")val title: String,
    @NonNull @ColumnInfo(name = "url")val url: String,
    @NonNull @ColumnInfo(name = "thumbnailUrl")val thumbnailUrl: String,
)

fun List<PhotosEntity>.asDomainModel(): List<Photos> {
    return map {
        Photos(
            id = it.id,
            albumId = it.albumId,
            title = it.title,
            url = it.url,
            thumbnailUrl = it.thumbnailUrl
        )
    }
}








/*: DomainMapper<Photos> {

    override fun mapToDomainModel() =
        Photos(0, 0, "", "", "")
}*/
/*
*//**
 * Map Database PhotosEntity to domain entities
 *//*

fun List<PhotosEntity>.asDomainModel(): List<Photos> {
    return map {
        Photos(
            albumId = it.albumId,
            id = it.id,
            title = it.title,
            url = it.url,
            thumbnailUrl = it.thumbnailUrl
        )
    }
}*/
