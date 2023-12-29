package com.example.myapplication

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion.factory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class IDModules {
    @Provides
    fun provideUrl() = "https://api.nytimes.com/svc/mostpopular/v2/emailed/"



    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
             level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(15, TimeUnit.SECONDS) //normal 10 Seconds
            .readTimeout(15, TimeUnit.SECONDS)
            .build()


    @Singleton
    @Provides
    fun provideApiService(url: String, okHttpClient: OkHttpClient): NewApiInterface =

        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                .setLenient()
                .create()))
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

            .build()
            .create(NewApiInterface::class.java)

    }
