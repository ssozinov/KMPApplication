package com.test.kmpapplication.domain
import com.test.kmpapplication.data.api.DTO.TrainingInfoDTO
import com.test.kmpapplication.domain.Models.TrainingInfo
import com.test.kmpapplication.utils.LoadState

interface TrainingRepository {
    suspend fun getTrainingInfo(): Result<TrainingInfoDTO>
}