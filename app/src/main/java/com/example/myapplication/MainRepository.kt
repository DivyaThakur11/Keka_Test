package com.example.myapplication

import androidx.annotation.Keep
import javax.inject.Inject

@Keep
    class MainRepository @Inject constructor(private val apiInterface: NewApiInterface) {
        suspend fun getContentList() = apiInterface.getList()
}