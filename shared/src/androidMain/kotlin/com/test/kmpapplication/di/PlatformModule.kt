package com.test.kmpapplication.di

import com.test.kmpapplication.platform.DriverFactory
import com.test.kmpapplication.platform.createDatabase
import org.koin.dsl.module

val platformModule = module {
    single { createDatabase(DriverFactory(get())) }
}