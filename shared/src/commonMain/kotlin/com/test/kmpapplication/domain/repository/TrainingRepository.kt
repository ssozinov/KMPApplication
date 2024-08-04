package com.test.kmpapplication.domain.repository

import com.test.kmpapplication.domain.Models.Trainer
import com.test.kmpapplication.domain.Models.TrainingInfo
import com.test.kmpapplication.platform.Either
import com.test.kmpapplication.platform.Failure

interface TrainingRepository {
    suspend fun getTrainingInfo(): Either<Failure, TrainingInfo>
    suspend fun getTrainers(clubId: String): Either<Failure, List<Trainer>>
}