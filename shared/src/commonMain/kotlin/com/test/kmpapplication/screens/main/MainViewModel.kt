package com.test.kmpapplication.screens.main

import com.test.kmpapplication.data.a.db.TrainingDataSource
import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.domain.UseCases.GetTrainingUseCase
import com.test.kmpapplication.platform.BaseScreenModel
import com.test.kmpapplication.utils.getFavouriteUI
import org.koin.core.component.inject

internal class MainViewModel : BaseScreenModel<MainState, MainEvent>(MainState.InitState) {

    private val getTrainingUseCase: GetTrainingUseCase by inject()
    private val dataSource: TrainingDataSource by inject()


    init {
        loadFavoriteTrainings()
        getAllTrainings()
    }

    fun getAllTrainings() = intent {
        launchOperation(
            operation = {
                getTrainingUseCase.execute(GetTrainingUseCase.Params(), it)
            },
            success = {
                reduceLocal {
                    it.lessons
                        .map {lesson -> if (state.favoriteTrainings.any { it.trainingID == lesson.trainingID }) lesson.isFavourite = true}
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

    private fun insertInFavorites(lesson: Lesson) = intent {
        dataSource.insertTraining(lesson)
        loadFavoriteTrainings()
    }

    private fun removeFromFavorites(lesson: Lesson) = intent {
        val favouriteItem = lesson.getFavouriteUI(state.favoriteTrainings)
        dataSource.deleteFavouriteItem(favouriteItem.id.toLong())
        loadFavoriteTrainings()
    }

    fun pressFavoriteButton(lesson: Lesson) = intent {
        val isFavorite = state.favoriteTrainings.any { it.trainingID == lesson.trainingID }
        val updatedTrainings = state.trainings.lessons.map {
            if (it.trainingID == lesson.trainingID) it.copy(isFavourite = !it.isFavourite) else it
        }
        if (isFavorite) {
            removeFromFavorites(lesson)

        } else {
            insertInFavorites(lesson)
        }
        reduce {
            state.copy(
                trainings = state.trainings.copy(lessons = updatedTrainings)
            )
        }
    }
}