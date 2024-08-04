package com.test.kmpapplication.data.a.DTO


import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class OptionDTO(
    @SerialName("club_name")
    val clubName: String?,
    @SerialName("link_android")
    val linkAndroid: String?,
    @SerialName("link_ios")
    val linkIos: String?,
    @SerialName("primary_color")
    val primaryColor: String?,
    @SerialName("secondary_color")
    val secondaryColor: String?
)