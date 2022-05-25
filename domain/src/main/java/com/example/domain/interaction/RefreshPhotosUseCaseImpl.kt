package com.example.domain.interaction

import com.example.domain.repository.PhotoRepository

class RefreshPhotosUseCaseImpl(private val repository: PhotoRepository) : RefreshPhotosUseCase {
    override suspend fun invoke() = repository.refreshPhotos()
}