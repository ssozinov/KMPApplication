package com.test.kmpapplication.data.a.DTO

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
@Serializable
data class TrainerDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("full_name")
    val fullName: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("image_url")
    val imageUrl: String?,
    @SerialName("image_url_medium")
    val imageUrlMedium: String?,
    @SerialName("image_url_small")
    val imageUrlSmall: String?,
    @SerialName("last_name")
    val lastName: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("position")
    val position: String?
)