package com.androidmodule.configappmodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.androidmodule.configapp.data.Resource
import com.androidmodule.configapp.viewmodel.ConfigAppViewModel
import org.koin.android.ext.android.inject

private const val TAG = "Log_MainActivity"

class MainActivity : AppCompatActivity() {

    private val configAppViewModel: ConfigAppViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configAppViewModel.getData(this.packageName, "sdfdf").observe(this) { resource ->
            when (resource) {
                is Resource.Error -> {
                    resource.message?.let { Log.e(TAG, it) }
                }
                is Resource.Loading -> {
                    Log.i(TAG, "Loading")
                }
                is Resource.Success -> {
                    Log.i(TAG, "Success: ${resource.data}")
                }
            }
        }
    }
}