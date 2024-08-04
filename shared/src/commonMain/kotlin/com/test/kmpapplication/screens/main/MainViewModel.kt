package com.test.kmpapplication.screens.main

import com.test.kmpapplication.domain.UseCases.GetTrainingUseCase
import com.test.kmpapplication.platform.BaseScreenModel
import org.koin.core.component.inject

internal class MainViewModel:BaseScreenModel<MainState, MainEvent>(MainState.InitState) {

    private val getTrainingUseCase: GetTrainingUseCase by inject()

    fun getAllTrainings() = intent {
        launchOperation(
            operation = {
                getTrainingUseCase.execute(GetTrainingUseCase.Params(),it)
            },
            success = {
                reduceLocal {
                    state.copy(trainings = it)
                }
            },
            failure = {

            }
        )
    }
}