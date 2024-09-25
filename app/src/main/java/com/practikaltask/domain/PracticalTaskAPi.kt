package com.practikaltask.domain

import com.practikaltask.presentation.main.model.PhotosData
import retrofit2.http.GET

interface PracticalTaskAPi {
    @GET("photos")
    suspend fun fetchPhotos(): List<PhotosData>
}