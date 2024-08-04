package com.test.kmpapplication.domain.UseCases

import com.test.kmpapplication.domain.Models.TrainingInfo
import com.test.kmpapplication.domain.repository.TrainingRepository
import com.test.kmpapplication.platform.BaseUseCase
import com.test.kmpapplication.platform.Either
import com.test.kmpapplication.platform.Failure
import kotlinx.coroutines.CoroutineScope

class GetTrainingUseCase(private val trainingRepository: TrainingRepository):
    BaseUseCase<GetTrainingUseCase.Params, TrainingInfo>() {
    class Params

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, TrainingInfo> {
        return trainingRepository.getTrainingInfo()
    }
}