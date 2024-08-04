package com.test.kmpapplication.android


import com.test.kmpapplication.screens.root.RootApp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootApp()
        }
    }
}