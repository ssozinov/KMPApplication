package com.test.kmpapplication.screens.main

import com.test.kmpapplication.data.a.db.TrainingDataSource
import com.test.kmpapplication.domain.Models.FavouriteUI
import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.domain.UseCases.GetTrainingUseCase
import com.test.kmpapplication.platform.BaseScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.inject

internal class MainViewModel : BaseScreenModel<MainState, MainEvent>(MainState.InitState) {

    private val getTrainingUseCase: GetTrainingUseCase by inject()
    private val dataSource: TrainingDataSource by inject()


    init {
        loadFavoriteTrainings()
        loadFavoriteTrainings()
    }

    fun getAllTrainings() = intent {
        launchOperation(
            operation = {
                getTrainingUseCase.execute(GetTrainingUseCase.Params(), it)
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

    fun loadFavoriteTrainings() = intent {
        val favorites = dataSource.loadAllTrainings()
        reduce {
            state.copy(
                favoriteTrainings = favorites
            )
        }
    }

    fun insertInFavorites(training: Lesson) = intent {
        dataSource.insertTraining(training)
        loadFavoriteTrainings()
    }

    fun removeFromFavorites(favorite: FavouriteUI) = intent {
        dataSource.deleteFavouriteItem(favorite.id.toLong())
        loadFavoriteTrainings()
    }
}