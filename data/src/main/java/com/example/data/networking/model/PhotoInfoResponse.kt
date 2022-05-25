package com.example.data.networking.model

import com.example.data.database.model.PhotosEntity
import com.example.domain.model.Photos

data class PhotoInfoResponse(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
)

fun List<PhotoInfoResponse>.asDomainModel(): List<Photos> {
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
fun List<PhotoInfoResponse>.asDatabaseModel(): List<PhotosEntity> {
    return map {
        PhotosEntity(
            albumId = it.albumId,
            id = it.id,
            url = it.url,
            title = it.title,
            thumbnailUrl = it.thumbnailUrl)
    }
}