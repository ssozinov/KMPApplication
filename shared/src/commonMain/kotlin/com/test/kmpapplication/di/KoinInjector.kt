package com.test.kmpapplication.di

import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

object AppConfig {
    var baseUrl: String = "https://olimpia.fitnesskit-admin.ru/"
}
object KoinInjector {
    var koinApp = startKoin {
        printLogger(Level.ERROR)
        properties(mapOf("BASE_URL" to "https://olimpia.fitnesskit-admin.ru/"))
        loadKoinModules(
            listOf(
                networkModule,
                apiModule,
                repositoryModule,
                useCaseModule
                )
        )
    }

    val koin = koinApp.koin

    fun updateBaseUrl(newBaseUrl: String) {
        koin.setProperty("BASE_URL", newBaseUrl)
        koin.declare(provideKtorHttpClient(koin.get(), newBaseUrl))
    }
}