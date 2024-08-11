package com.test.kmpapplication.screens.favourite

import com.test.kmpapplication.domain.Models.FavouriteUI

data class FavouriteState(
    val items: List<FavouriteUI>
) {
    companion object {
        val InitState = FavouriteState(
            items = emptyList()
        )
    }
}