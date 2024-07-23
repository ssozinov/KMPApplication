package com.test.kmpapplication.data.api

import com.test.kmpapplication.data.api.DTO.TrainingInfoDTO
import com.test.kmpapplication.utils.LoadState
import de.jensklingenberg.ktorfit.http.GET


interface ApiService {
    @GET ("/schedule/get_v3/?club_id=2")
    suspend fun getTrainingInfo(): TrainingInfoDTO
}