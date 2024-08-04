package com.test.kmpapplication.di

import de.jensklingenberg.ktorfit.ktorfit
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpRedirect
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.plugin
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private const val TIME_OUT = 30000L

internal val networkModule = module {
    factoryOf(::provideJson)
    factoryOf(::provideHttpClient)
    factory {
        val baseUrl: String = getKoin().getProperty("BASE_URL") ?: "https://olimpia.fitnesskit-admin.ru/"
        provideKtorHttpClient(get(), baseUrl)
    }
}

@OptIn(ExperimentalSerializationApi::class)
private fun provideJson(): Json {
    return Json {
        isLenient = true
        ignoreUnknownKeys = true
        explicitNulls = false
        encodeDefaults = true
        prettyPrint = true
    }
}

private fun provideHttpClient(
    json: Json
) = HttpClient {

    install(HttpRedirect) {
        checkHttpMethod = false
        allowHttpsDowngrade = false
    }

    defaultRequest {
        header(
            "Content-Type", "application/json"
        )
    }


    install(ContentNegotiation) {
        json(json)
    }

    HttpResponseValidator {
        handleResponseExceptionWithRequest { cause, request ->
            print(cause)
            print(request)
        }
    }


    install(HttpTimeout) {
        connectTimeoutMillis = TIME_OUT
        requestTimeoutMillis = TIME_OUT
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println("json: \n $message")
            }

        }
        level = LogLevel.ALL
    }

}

fun provideKtorHttpClient(
    httpClient: HttpClient,
    baseUrl: String
): Ktorfit {

    return ktorfit {
        baseUrl(baseUrl)
        httpClient(httpClient)
    }
}