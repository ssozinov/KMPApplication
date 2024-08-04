package com.test.kmpapplication.di
import com.test.kmpapplication.data.a.repository.TrainingRepositoryImpl
import com.test.kmpapplication.domain.repository.TrainingRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.component.get

internal val repositoryModule = module {
    factory<TrainingRepository> { TrainingRepositoryImpl(get()) }
}