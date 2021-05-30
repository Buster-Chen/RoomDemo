package com.aoh404.roomdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aoh404.roomdemo.repo.WeddingRepository
import com.aoh404.roomdemo.model.WeddingProfile

class WeddingViewModel(
    private val repository: WeddingRepository
) : ViewModel() {

    fun loadWeddingProfile(): LiveData<WeddingProfile> = repository.loadWeddingProfile()
}