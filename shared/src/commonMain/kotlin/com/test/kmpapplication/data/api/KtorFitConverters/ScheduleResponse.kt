package com.test.kmpapplication.data.api.KtorFitConverters

sealed class TrainingResponse<T> {
    data class Success<T>(val data: T) : TrainingResponse<T>()
    class Error(val ex:Throwable) : TrainingResponse<Nothing>()

    companion object {
        fun <T> success(data: T) = Success(data)
        fun error(ex: Throwable) = Error(ex)
    }
}