package com.androidmodule.configapp.data.remote

import com.androidmodule.configapp.domain.ConfigApp
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("configApp/apps")
    suspend fun getData(
        @Query("packageName") packageName: String?
    ): ConfigApp
}