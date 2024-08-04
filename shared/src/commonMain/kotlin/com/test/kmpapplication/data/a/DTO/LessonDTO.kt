package com.test.kmpapplication.data.a.DTO

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class LessonDTO(
    @SerialName("appointment_id")
    val appointmentId: String?,
    @SerialName("available_slots")
    val availableSlots: Int?,
    @SerialName("client_recorded")
    val clientRecorded: Boolean?,
    @SerialName("coach_id")
    val coachId: String?,
    @SerialName("color")
    val color: String?,
    @SerialName("commercial")
    val commercial: Boolean?,
    @SerialName("date")
    val date: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("endTime")
    val endTime: String?,
    @SerialName("is_cancelled")
    val isCancelled: Boolean?,
    @SerialName("name")
    val name: String?,
    @SerialName("place")
    val place: String?,
    @SerialName("service_id")
    val serviceId: String?,
    @SerialName("startTime")
    val startTime: String?,
    @SerialName("tab")
    val tab: String?,
    @SerialName("tab_id")
    val tabId: Int?
)