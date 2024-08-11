package com.test.kmpapplication.data.a.repository

import com.test.kmpapplication.data.a.Mapper.toTrainers
import com.test.kmpapplication.data.a.Mapper.toTraningInfo
import com.test.kmpapplication.data.a.api.ApiService
import com.test.kmpapplication.domain.Models.Trainer
import com.test.kmpapplication.domain.Models.TrainingInfo
import com.test.kmpapplication.domain.repository.TrainingRepository
import com.test.kmpapplication.platform.Either
import com.test.kmpapplication.platform.Failure
import com.test.kmpapplication.platform.apiCall

class TrainingRepositoryImpl(private val apiService: ApiService) : TrainingRepository {
    override suspend fun getTrainingInfo(): Either<Failure, TrainingInfo> {
        return apiCall(
            call = { apiService.getTrainingInfo() },
            mapResponse = { response ->
                response.toTraningInfo()
            }
        )
    }

    override suspend fun getTrainers(clubId:String): Either<Failure, List<Trainer>> {
        return apiCall (
            call = {apiService.getTrainersInfo(clubId)},
            mapResponse = {response ->
                response.trainers?.filterNotNull()!!.map { it.toTrainers() }
            }
        )
    }
}