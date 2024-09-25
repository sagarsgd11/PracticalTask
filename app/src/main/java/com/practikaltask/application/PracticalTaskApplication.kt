package com.practikaltask.application

import android.app.Application
import com.practikaltask.di.networkModule
import com.practikaltask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PracticalTaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        koinStart()
    }

    private fun koinStart() {
        startKoin {
            androidContext(this@PracticalTaskApplication)
            modules(listOf(networkModule, viewModelModule))
        }
    }

}