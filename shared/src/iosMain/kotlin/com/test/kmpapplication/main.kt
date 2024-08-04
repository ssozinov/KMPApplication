package com.test.kmpapplication

import androidx.compose.ui.window.ComposeUIViewController
import com.test.kmpapplication.di.KoinInjector
import com.test.kmpapplication.screens.root.RootApp
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {
    KoinInjector.koinApp
    return ComposeUIViewController {
        RootApp()
    }
}