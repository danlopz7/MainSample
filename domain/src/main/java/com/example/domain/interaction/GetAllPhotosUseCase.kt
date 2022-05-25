package com.example.domain.interaction

import androidx.lifecycle.LiveData
import com.example.domain.model.Photos

interface GetAllPhotosUseCase {
    suspend operator fun invoke(): LiveData<List<Photos>>
}