package com.aoh404.roomdemo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeddingProfile(
    @PrimaryKey
    val id: Int,
    val weddingDate: String?
)