package com.aoh404.roomdemo.weddinginfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aoh404.roomdemo.model.WeddingProfile
import com.aoh404.roomdemo.repo.WeddingRepository

class EditingWeddingInfoViewModel(
    private val repository: WeddingRepository
) : ViewModel() {

    fun loadWeddingProfile(): LiveData<WeddingProfile> = repository.loadWeddingProfile()

    fun addWeddingProfile(weddingProfile: WeddingProfile) = repository.addWeddingProfile(weddingProfile)
}