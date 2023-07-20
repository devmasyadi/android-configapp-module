package com.androidmodule.configapp.data.remote

import com.androidmodule.configapp.domain.ConfigApp
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("apps")
    suspend fun getData(
        @Query("appId") appId: String?,
        @Query("hashId") hashId: String?
    ): ConfigApp
}