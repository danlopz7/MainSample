package com.example.data.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private const val BASE_URL: String =
        "https://jsonplaceholder.typicode.com"
    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val retrofitService: PhotosApi by lazy {
        retrofit.create(PhotosApi::class.java)
    }
}