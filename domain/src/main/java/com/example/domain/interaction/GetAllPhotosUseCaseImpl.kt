package com.example.domain.interaction

import com.example.domain.repository.PhotoRepository

class GetAllPhotosUseCaseImpl(private val photoRepository: PhotoRepository) : GetAllPhotosUseCase {
    override suspend fun invoke() = photoRepository.getAllPhotos()
}