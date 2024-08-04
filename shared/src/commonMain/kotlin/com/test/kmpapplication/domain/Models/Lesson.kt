package com.test.kmpapplication.domain.Models


data class Lesson(
    val appointmentId: String,
    val availableSlots: Int,
    val clientRecorded: Boolean,
    val coachId: String,
    val color: String,
    val commercial: Boolean,
    val date: String,
    val description: String,
    val endTime: String,
    val isCancelled: Boolean,
    val name: String,
    val place: String,
    val serviceId: String,
    val startTime: String,
    val tab: String,
    val tabId: Int,
    val trainerImage: String
)