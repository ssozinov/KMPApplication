package com.test.kmpapplication.di

import com.test.kmpapplication.data.a.db.TrainingDataSource
import org.koin.dsl.module


val dataSourceModule = module {
    single { TrainingDataSource(get()) }
}