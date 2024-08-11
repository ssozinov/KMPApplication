package com.test.kmpapplication

import androidx.compose.ui.window.ComposeUIViewController
import com.test.kmpapplication.di.KoinInjector
import com.test.kmpapplication.platform.DriverFactory
import com.test.kmpapplication.platform.createDatabase
import com.test.kmpapplication.screens.root.RootApp
import platform.UIKit.UIViewController
import org.koin.dsl.module


fun MainViewController(): UIViewController {
    KoinInjector.loadModules(listOf(platformModule))
    return ComposeUIViewController {
        RootApp()
    }
}

val platformModule = module {
    single { createDatabase(DriverFactory()) }
}