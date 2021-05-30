package com.aoh404.roomdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aoh404.roomdemo.WeddingRepository
import com.aoh404.roomdemo.data.WeddingProfile

class WeddingViewModel(
    private val repository: WeddingRepository
) : ViewModel() {

    fun loadWeddingProfile(): LiveData<WeddingProfile> = repository.loadWeddingProfile()
}