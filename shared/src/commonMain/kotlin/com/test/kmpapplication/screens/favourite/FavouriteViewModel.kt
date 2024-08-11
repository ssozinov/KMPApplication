package com.test.kmpapplication.screens.favourite

import com.test.kmpapplication.data.a.db.TrainingDataSource
import com.test.kmpapplication.platform.BaseScreenModel
import org.koin.core.component.inject

internal class FavouriteViewModel :
    BaseScreenModel<FavouriteState, FavouriteEvent>(FavouriteState.InitState) {

    private val trainingDataSource: TrainingDataSource by inject()

    fun loadTrainings() = intent {
        val items = trainingDataSource.loadAllTrainings()
        reduce {
            state.copy(
                items = items
            )
        }
    }

    fun deleteItem(id: Long) = intent {
        trainingDataSource.deleteFavouriteItem(id)
        reduce {
            state.copy(
                items = state.items.filter { it.id.toLong() != id }
            )
        }
    }

    fun clearTrainings() = intent {
        trainingDataSource.cleanFavourites()
        reduce {
            state.copy(
                items = emptyList()
            )
        }
    }

}