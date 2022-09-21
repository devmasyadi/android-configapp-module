package com.androidmodule.configapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.androidmodule.configapp.data.Repository

class ConfigAppViewModel(private val repository: Repository) : ViewModel() {
    fun getData(packageName: String) = repository.getData(packageName).asLiveData()
}