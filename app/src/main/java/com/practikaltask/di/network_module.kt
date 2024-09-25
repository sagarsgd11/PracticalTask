package com.practikaltask.di

import com.practikaltask.domain.PracticalTaskAPi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { createOkHttpClient() }
    single { createWebService(get()) }
}

fun createOkHttpClient(): OkHttpClient {
    val cookieManager = CookieManager()
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient().newBuilder().connectTimeout(1L, TimeUnit.MINUTES)
        .readTimeout(1L, TimeUnit.MINUTES).addInterceptor(httpLoggingInterceptor).build()
}

fun createWebService(okHttpClient: OkHttpClient): PracticalTaskAPi {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(PracticalTaskAPi::class.java)
}