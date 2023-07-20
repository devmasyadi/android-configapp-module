package com.androidmodule.configapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.androidmodule.configapp.data.Repository

class ConfigAppViewModel(private val repository: Repository) : ViewModel() {
    fun getData(appId: String, hashId: String) = repository.getData(appId, hashId).asLiveData()
}