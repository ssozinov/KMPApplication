package com.test.kmpapplication.data.a.db

import com.test.kmpapplication.Database
import com.test.kmpapplication.domain.Models.FavouriteUI
import com.test.kmpapplication.domain.Models.Lesson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TrainingDataSource(private val db: Database) {
    private val table = db.trainingQueries
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    fun insertTraining(training: Lesson) {
        scope.launch {
            table.insertTraining(
                date = training.date,
                startTime = training.startTime,
                place = training.place,
                tab = training.tab,
                trainerImage = training.trainerImage
            )
        }
    }

    suspend fun loadAllTrainings(): List<FavouriteUI> {
        val result = scope.async {
            table.loadTrainingFromBucket().executeAsList().map {
                FavouriteUI(
                    id = it.id.toInt(),
                    date = it.date.orEmpty(),
                    startTime = it.startTime.orEmpty(),
                    place = it.place.orEmpty(),
                    tab = it.tab.orEmpty(),
                    trainerImage = it.trainerImage.orEmpty()
                )
            }
        }.await()
        return result
    }

    fun deleteFavouriteItem(id: Long) {
        scope.launch {
            table.deleteTrainingFromBucketByID(id)

        }
    }

    fun cleanFavourites() {
        scope.launch {
            table.deleteTrainingBucket()
        }
    }
}