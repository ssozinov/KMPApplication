package com.test.kmpapplication.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.test.kmpapplication.images.KMPResourceImages
import com.test.kmpapplication.screens.main.MainScreen
import com.test.kmpapplication.screens.mainTab.MainTabScreen
import com.test.kmpapplication.strings.KMPResourceStrings
import io.github.skeptick.libres.compose.painterResource

object MainTab: Tab {

    @Composable
    override fun Content() {
        Navigator(MainScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1.toUShort(),
            title = KMPResourceStrings.main,
            icon =  KMPResourceImages.user.painterResource()
        )
}