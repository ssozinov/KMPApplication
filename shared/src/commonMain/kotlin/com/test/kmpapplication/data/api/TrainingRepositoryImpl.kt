package com.test.kmpapplication.data.api

import com.test.kmpapplication.data.api.DTO.TrainingInfoDTO
import com.test.kmpapplication.domain.TrainingRepository

class TrainingRepositoryImpl(private val apiService: ApiService) : TrainingRepository {
    override suspend fun getTrainingInfo(): Result<TrainingInfoDTO> {
        return kotlin.runCatching {
          apiService.getTrainingInfo()
        }
    }
}