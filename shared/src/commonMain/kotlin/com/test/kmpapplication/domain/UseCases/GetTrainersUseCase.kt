package com.test.kmpapplication.domain.UseCases

import com.test.kmpapplication.domain.Models.Trainer
import com.test.kmpapplication.domain.repository.TrainingRepository
import com.test.kmpapplication.platform.BaseUseCase
import com.test.kmpapplication.platform.Either
import com.test.kmpapplication.platform.Failure
import kotlinx.coroutines.CoroutineScope

class GetTrainersUseCase(private val trainingRepository: TrainingRepository) :
    BaseUseCase<GetTrainersUseCase.Params, List<Trainer>>() {

    class Params(val id: String)

    override suspend fun execute(
        params: Params,
        scope: CoroutineScope
    ): Either<Failure, List<Trainer>> {
        return trainingRepository.getTrainers(params.id)
    }
}