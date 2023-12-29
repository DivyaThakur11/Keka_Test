package com.example.myapplication

import androidx.annotation.Keep
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
@Keep
interface NewApiInterface {

    @GET("7.json?api-key=j5GCulxBywG3lX211ZAPkAB8O381S5SM")
  suspend  fun getList( ): Response<Root>


}