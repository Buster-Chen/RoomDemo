package com.aoh404.roomdemo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aoh404.roomdemo.data.WeddingDataBase
import com.aoh404.roomdemo.weddinginfo.EditingWeddingInfoViewModel

class ViewModelFactory(context: Context) : ViewModelProvider.NewInstanceFactory() {

    private val weddingRepository = WeddingRepository(WeddingDataBase.getInstance(context).getWeddingDao())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(WeddingViewModel::class.java) -> WeddingViewModel(weddingRepository)
                isAssignableFrom(EditingWeddingInfoViewModel::class.java) -> EditingWeddingInfoViewModel(weddingRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}