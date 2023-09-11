package com.google.android.material.configapp.data

import com.google.android.material.configapp.domain.ConfigApp
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getData(appId: String, hashId: String): Flow<Resource<ConfigApp>>
}