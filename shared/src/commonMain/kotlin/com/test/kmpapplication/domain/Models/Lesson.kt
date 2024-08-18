package com.test.kmpapplication.domain.Models

import com.benasher44.uuid.uuidOf
import io.ktor.utils.io.charsets.Charsets.UTF_8
import io.ktor.utils.io.core.toByteArray


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
    val trainerImage: String,
    var isFavourite: Boolean = false,
    val trainingID: String = generateUUID(date, startTime, place, description)
) {
    companion object {
        fun generateUUID(date: String, startTime: String, place: String, description: String): String {
            val input = "$date$startTime$place$description"
            val hash = input.toByteArray(UTF_8).fold(0L) { acc, byte -> acc * 31 + byte.toLong() }
            val uuidBytes = ByteArray(16)
            for (i in 0 until 16) {
                uuidBytes[i] = (hash shr (i * 8)).toByte()
            }
            return uuidOf(uuidBytes).toString()
        }
    }
}