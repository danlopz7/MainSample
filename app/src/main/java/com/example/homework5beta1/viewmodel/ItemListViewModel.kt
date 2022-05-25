package com.example.homework5beta1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interaction.GetAllPhotosUseCase
import com.example.domain.interaction.RefreshPhotosUseCase
import com.example.domain.model.Photos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ItemListViewModel @Inject constructor(
    val getAllPhotosUseCase: GetAllPhotosUseCase,
    val refreshPhotosUseCase: RefreshPhotosUseCase
) : ViewModel()  {

    lateinit var photos: LiveData<List<Photos>>

    private val _navigateToSelectedPhoto = MutableLiveData<Photos?>()
    val navigateToSelectedPhoto: LiveData<Photos?>
        get() = _navigateToSelectedPhoto

    init {
        refreshData()
        getPhotosFromRepository()
    }

    private fun refreshData() {
        viewModelScope.launch {
            try {
                refreshPhotosUseCase.invoke()
            } catch (e: Exception) {

            }
        }
    }

    private fun getPhotosFromRepository() {
        viewModelScope.launch {
            try {
                photos = getAllPhotosUseCase.invoke()

            } catch (e: Exception) {
            }
        }
    }

    fun displayPhotoDetails(photo: Photos) {
        _navigateToSelectedPhoto.value = photo
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
 }