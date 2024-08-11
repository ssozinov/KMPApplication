package com.test.kmpapplication.screens.main

import com.test.kmpapplication.data.a.db.TrainingDataSource
import com.test.kmpapplication.domain.Models.FavouriteUI
import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.domain.UseCases.GetTrainingUseCase
import com.test.kmpapplication.platform.BaseScreenModel
import org.koin.core.component.inject

internal class MainViewModel:BaseScreenModel<MainState, MainEvent>(MainState.InitState) {

    private val getTrainingUseCase: GetTrainingUseCase by inject()
    private val dataSource: TrainingDataSource by inject()

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

    fun insertInFavorites(training: Lesson) = intent {
        dataSource.insertTraining(training)
    }
}