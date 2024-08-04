package com.test.kmpapplication.data.a.api

import com.test.kmpapplication.data.a.DTO.TrainingDTO
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query


interface ApiService {
    @GET ("schedule/get_v3/?club_id=2")
    suspend fun getTrainingInfo(): TrainingDTO

    @GET ("schedule/get_v3/")
    suspend fun getTrainersInfo(@Query("club_id") id: String): TrainingDTO
}