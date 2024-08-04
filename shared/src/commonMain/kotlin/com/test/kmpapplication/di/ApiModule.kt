package com.test.kmpapplication.di

import com.test.kmpapplication.data.a.api.ApiService
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

internal val apiModule = module {
    factory { get <Ktorfit>().create<ApiService>() }
}