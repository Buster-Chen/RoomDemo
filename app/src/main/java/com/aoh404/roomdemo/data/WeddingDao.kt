package com.aoh404.roomdemo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aoh404.roomdemo.data.WeddingProfile

@Dao
interface WeddingDao {
    @Query("SELECT * FROM WeddingProfile")
    fun loadWeddingProfile(): LiveData<WeddingProfile>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWeddingProfile(weddingProfile: WeddingProfile)
}