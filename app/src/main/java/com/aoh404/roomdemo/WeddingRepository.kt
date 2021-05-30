package com.aoh404.roomdemo

import androidx.lifecycle.LiveData
import com.aoh404.roomdemo.data.WeddingDao
import com.aoh404.roomdemo.data.WeddingDataBase
import com.aoh404.roomdemo.data.WeddingProfile

class WeddingRepository(private val weddingDao: WeddingDao) {
    fun loadWeddingProfile(): LiveData<WeddingProfile> = weddingDao.loadWeddingProfile()

    fun addWeddingProfile(weddingProfile: WeddingProfile) {
        WeddingDataBase.EXECUTOR_SERVICE.execute {
            weddingDao.addWeddingProfile(weddingProfile)
        }
    }
}