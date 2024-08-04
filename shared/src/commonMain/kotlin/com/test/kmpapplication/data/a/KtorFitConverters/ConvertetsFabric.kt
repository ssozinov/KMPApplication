package com.test.kmpapplication.data.a.KtorFitConverters

import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.Converter
import de.jensklingenberg.ktorfit.converter.KtorfitResult
import de.jensklingenberg.ktorfit.converter.TypeData
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

class TrainingConverterFactory : Converter.Factory{

    override fun suspendResponseConverter(
        typeData: TypeData,
        ktorfit: Ktorfit
    ): Converter.SuspendResponseConverter<HttpResponse, *>? {
        if(typeData.typeInfo.type == TrainingResponse::class) {
            return object : Converter.SuspendResponseConverter<HttpResponse, Any> {
                override suspend fun convert(result: KtorfitResult): Any {
                    return try {
                        TrainingResponse.success(result)
                    } catch (ex: Throwable) {
                        TrainingResponse.error(ex)
                    }
                }
            }
        }
        return null
    }
}