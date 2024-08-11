package com.test.kmpapplication.android

import android.app.Application
import com.test.kmpapplication.di.KoinInjector
import com.test.kmpapplication.di.platformModule
import org.koin.android.ext.koin.androidContext

class KMPApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInjector.koinApp.androidContext(this)
        KoinInjector.loadModules(listOf(platformModule))
    }
}