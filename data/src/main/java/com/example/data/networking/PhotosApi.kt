package com.example.data.networking

import com.example.data.networking.model.PhotoInfoResponse
import com.example.domain.model.Photos
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotosApi {

    @GET("photos")
    suspend fun getPhotos(@Query("_start") start: Int = 0, @Query("_limit") limit: Int = 25): List<PhotoInfoResponse>
}