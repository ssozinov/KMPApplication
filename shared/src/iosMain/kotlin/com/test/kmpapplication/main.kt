package com.test.kmpapplication

import androidx.compose.ui.window.ComposeUIViewController
import com.test.kmpapplication.root.RootApp
import platform.UIKit.UIViewController


fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        RootApp()
    }
}