package com.example.domain.di

import com.example.domain.interaction.GetAllPhotosUseCase
import com.example.domain.interaction.GetAllPhotosUseCaseImpl
import com.example.domain.interaction.RefreshPhotosUseCase
import com.example.domain.interaction.RefreshPhotosUseCaseImpl
import com.example.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module


@InstallIn(SingletonComponent::class)
@Module
class InteractionModule {

    @Provides
    fun provideGetAllPhotosUseCase(repository: PhotoRepository): GetAllPhotosUseCase {
        return GetAllPhotosUseCaseImpl(repository)
    }
    @Provides
    fun provideRefreshPhotosUseCase(repository: PhotoRepository): RefreshPhotosUseCase {
        return RefreshPhotosUseCaseImpl(repository)
    }
}