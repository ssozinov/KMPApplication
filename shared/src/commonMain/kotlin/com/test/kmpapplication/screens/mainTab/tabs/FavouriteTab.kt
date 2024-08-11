package com.test.kmpapplication.screens.mainTab.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.test.kmpapplication.images.KMPResourceImages
import com.test.kmpapplication.screens.favourite.FavouriteScreen
import com.test.kmpapplication.strings.KMPResourceStrings
import io.github.skeptick.libres.compose.painterResource

object FavouriteTab: Tab {
    @Composable
    override fun Content() {
        Navigator(FavouriteScreen())
    }

    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 3.toUShort(),
            title = KMPResourceStrings.favourite,
            icon =  KMPResourceImages.favorite.painterResource()
        )
}