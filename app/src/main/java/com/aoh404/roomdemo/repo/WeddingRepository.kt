package com.aoh404.roomdemo.repo

import androidx.lifecycle.LiveData
import com.aoh404.roomdemo.KEY_WEDDING_PROFILE
import com.aoh404.roomdemo.LiveDataBus
import com.aoh404.roomdemo.model.WeddingProfile

class WeddingRepository {
    fun loadWeddingProfile(): LiveData<WeddingProfile> =
        LiveDataBus.get().with(KEY_WEDDING_PROFILE, WeddingProfile::class.java)

    fun addWeddingProfile(weddingProfile: WeddingProfile) {
        LiveDataBus.get().with(KEY_WEDDING_PROFILE).value = weddingProfile
    }
}