package com.test.kmpapplication.screens.main

import com.test.kmpapplication.domain.Models.TrainingInfo

data class MainState(
    val trainings: TrainingInfo
) {
    companion object {
        val InitState = MainState(trainings = TrainingInfo(emptyList(), emptyList()))
    }
}