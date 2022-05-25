package com.example.domain.interaction

interface RefreshPhotosUseCase {
    suspend operator fun invoke(): Unit
}