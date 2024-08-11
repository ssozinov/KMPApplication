package com.test.kmpapplication.screens.trainers

import com.test.kmpapplication.domain.UseCases.GetTrainersUseCase
import com.test.kmpapplication.platform.BaseScreenModel
import org.koin.core.component.inject

internal class TrainerViewModel :
    BaseScreenModel<TrainerState, TrainerEvent>(TrainerState.InitState) {

    private val getTrainersUseCase: GetTrainersUseCase by inject()
    fun getTrainers(clubId: String) = intent {
        launchOperation(
            operation = {
                getTrainersUseCase.execute(GetTrainersUseCase.Params(id = clubId), it)
            },
            success = {
                reduceLocal {
                    state.copy(
                        trainers = it
                    )
                }
            }
        )
    }
}