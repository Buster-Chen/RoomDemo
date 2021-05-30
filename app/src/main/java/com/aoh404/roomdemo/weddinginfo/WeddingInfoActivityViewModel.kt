package com.aoh404.roomdemo.weddinginfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aoh404.roomdemo.Event


class WeddingInfoActivityViewModel: ViewModel() {

    private val _navigateToEditingWeddingInfoAction = MutableLiveData<Event<Unit>>()
    val navigateToEditingWeddingInfoAction: LiveData<Event<Unit>>
        get() = _navigateToEditingWeddingInfoAction

    fun navigateToEditingWeddingInfoFragment() {
        _navigateToEditingWeddingInfoAction.value = Event(Unit)
    }
}