package com.androidmodule.configapp.data

import com.androidmodule.configapp.data.remote.ApiService
import com.androidmodule.configapp.domain.ConfigApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(
    private val apiService: ApiService
) : IRepository {
    override fun getData(appId: String, hashId: String): Flow<Resource<ConfigApp>> {
        return flow {
            try {
                emit(Resource.Loading())
                val result = apiService.getData(appId, hashId)
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}