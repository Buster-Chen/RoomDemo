package com.aoh404.roomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [WeddingProfile::class], version = 1, exportSchema = false)
abstract class WeddingDataBase : RoomDatabase() {
    abstract fun getWeddingDao(): WeddingDao

    companion object {
        @Volatile
        private var INSTANCE: WeddingDataBase? = null

        val EXECUTOR_SERVICE: ExecutorService = Executors.newFixedThreadPool(4)

        @JvmStatic
        fun getInstance(context: Context): WeddingDataBase {
            return INSTANCE ?: synchronized(WeddingDataBase::class.java) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    WeddingDataBase::class.java,
                    "wedding_database"
                )
                    .build()
                    .also { INSTANCE = it }
            }
        }

    }
}