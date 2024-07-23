package com.test.kmpapplication.data.api.DTO

import kotlinx.serialization.Serializable

@Serializable
data class TabDTO(
    val id: Int?,
    val name: String?
)