package com.test.kmpapplication.di

import com.test.kmpapplication.domain.UseCases.GetTrainingUseCase
import com.test.kmpapplication.domain.UseCases.GetTrainersUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

internal val useCaseModule = module {
    factoryOf(::GetTrainingUseCase)
    factoryOf(::GetTrainersUseCase)
}