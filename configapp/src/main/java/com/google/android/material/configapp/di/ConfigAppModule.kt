package com.google.android.material.configapp.di

import com.google.android.material.configapp.data.Repository
import com.google.android.material.configapp.data.remote.ApiService
import com.google.android.material.configapp.viewmodel.ConfigAppViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val configAppModule = module {
    factory {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.NONE)

        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .build()
    }

    factory {
        val retrofit = ConfigAppStyle.style?.let { url ->
            Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }
        retrofit?.create(ApiService::class.java)
    }

    single { Repository(get()) }
    viewModel { ConfigAppViewModel(get()) }
}

object ConfigAppStyle {
    var style: String? = null
}
