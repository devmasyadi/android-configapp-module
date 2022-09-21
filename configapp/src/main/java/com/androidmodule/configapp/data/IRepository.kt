package com.androidmodule.configapp.data

import com.androidmodule.configapp.domain.ConfigApp
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getData(packageName: String): Flow<Resource<ConfigApp>>
}