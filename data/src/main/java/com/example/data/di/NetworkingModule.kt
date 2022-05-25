package com.example.data.di

import com.example.data.networking.ApiService
import com.example.data.networking.PhotosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providePostService(): PhotosApi {
        return ApiService.retrofitService
    }
}