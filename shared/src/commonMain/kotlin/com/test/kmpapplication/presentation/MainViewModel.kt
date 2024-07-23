package com.test.kmpapplication.presentation

import com.test.kmpapplication.data.api.ApiService
import de.jensklingenberg.ktorfit.Ktorfit

class MainViewModel {
    private val ktorfit = Ktorfit.Builder().baseUrl("https://olimpia.fitnesskit-admin.ru/").build()
    private val fitnessAPI = ktorfit.create<ApiService>()

    private val result =
        kotlinx.coroutines.runBlocking {
            fitnessAPI.getTrainingInfo()
        }

}