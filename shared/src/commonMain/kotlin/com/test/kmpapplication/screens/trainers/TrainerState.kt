package com.test.kmpapplication.screens.trainers

import com.test.kmpapplication.domain.Models.Trainer

data class TrainerState(
    val trainers: List<Trainer>
) {
    companion object {
        val InitState = TrainerState(trainers = emptyList())
    }
}