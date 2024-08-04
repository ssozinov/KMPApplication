package com.test.kmpapplication.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.test.kmpapplication.images.KMPResourceImages
import com.test.kmpapplication.screens.trainers.TrainerScreen
import com.test.kmpapplication.strings.KMPResourceStrings
import io.github.skeptick.libres.compose.painterResource

object TrainerTab: Tab {

    @Composable
    override fun Content() {
        Navigator(TrainerScreen("2"))
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2.toUShort(),
            title = KMPResourceStrings.trainer,
            icon = KMPResourceImages.training.painterResource(),
        )
}