package com.test.kmpapplication.data.api.DTO

import kotlinx.serialization.Serializable

@Serializable
data class TrainerDTO(
    val description: String?,
    val fullName: String?,
    val id: String?,
    val imageUrl: String?,
    val imageUrlMedium: String?,
    val imageUrlSmall: String?,
    val lastName: String?,
    val name: String?,
    val position: String?
)