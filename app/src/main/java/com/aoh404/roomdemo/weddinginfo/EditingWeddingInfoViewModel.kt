package com.aoh404.roomdemo.weddinginfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.aoh404.roomdemo.WeddingRepository
import com.aoh404.roomdemo.data.WeddingProfile

class EditingWeddingInfoViewModel(
    private val repository: WeddingRepository
) : ViewModel() {

    fun loadWeddingProfile(): LiveData<WeddingProfile> = repository.loadWeddingProfile()

    fun addWeddingProfile(weddingProfile: WeddingProfile) = repository.addWeddingProfile(weddingProfile)
}