package com.practikaltask.presentation.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.practikaltask.domain.PracticalTaskAPi
import com.practikaltask.presentation.base.viewmodel.BaseViewModel
import com.practikaltask.presentation.main.model.PhotosData
import kotlinx.coroutines.launch

class MainViewModel(private val practicalTaskAPi: PracticalTaskAPi) : BaseViewModel() {

    val photosResponseObserver: MutableLiveData<List<PhotosData>> = MutableLiveData()

    fun fetchPhotosFromServer() {
        launch {
            kotlin.runCatching {
                practicalTaskAPi.fetchPhotos()
            }.fold(
                {
                    photosResponseObserver.postValue(it)
                }, {
                    expectationLiveData.postValue(it)
                }
            )
        }
    }

}