package com.example.redemption.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redemption.model.Photo
import com.example.redemption.network.ApiService
import kotlinx.coroutines.launch

class PhotoListViewModel: ViewModel() {
    var photoListResponse:List<Photo> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getPhotos() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val photoList = apiService.getMovies()
                photoListResponse = photoList
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}