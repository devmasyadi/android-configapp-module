package com.androidmodule.configapp.data

import com.androidmodule.configapp.domain.ConfigApp
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getData(appId: String, hashId: String): Flow<Resource<ConfigApp>>
}