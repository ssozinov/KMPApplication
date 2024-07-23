package com.test.kmpapplication.data.api.DTO

import kotlinx.serialization.Serializable

@Serializable
data class OptionDTO(
    val clubName: String?,
    val linkAndroid: String?,
    val linkIos: String?,
    val primaryColor: String?,
    val secondaryColor: String?
)