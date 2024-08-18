package com.test.kmpapplication.screens.main

import com.test.kmpapplication.domain.Models.FavouriteUI
import com.test.kmpapplication.domain.Models.TrainingInfo

data class MainState(
    val trainings: TrainingInfo,
    val favoriteTrainings: List<FavouriteUI>,
) {
    companion object {
        val InitState = MainState(trainings = TrainingInfo(emptyList(), emptyList()), favoriteTrainings = emptyList())
    }
}