package com.test.kmpapplication.data.a.DTO


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class TabDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?
)