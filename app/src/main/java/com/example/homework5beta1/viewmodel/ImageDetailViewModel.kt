package com.example.homework5beta1.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.model.Photos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle) : ViewModel() {

    val selectedPhoto: Photos = savedStateHandle.get<Photos>(PHOTO_SELECTED)!!

    companion object {
        private const val PHOTO_SELECTED = "selectedPhoto"
    }
}
