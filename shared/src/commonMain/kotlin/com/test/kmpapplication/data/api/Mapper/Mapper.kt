package com.test.kmpapplication.data.api.Mapper

import com.test.kmpapplication.data.api.DTO.LessonDTO
import com.test.kmpapplication.data.api.DTO.TrainingInfoDTO
import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.domain.Models.TrainingInfo

fun TrainingInfoDTO.toTraningInfo(): TrainingInfo {
    return TrainingInfo(
        lessons = lessons?.filterNotNull()!!.map { it.toLesson() }
    )
}

fun LessonDTO.toLesson(): Lesson {
    return Lesson (
        appointmentId = appointmentId ?: "",
        availableSlots = availableSlots ?: 0,
        clientRecorded = clientRecorded ?: false,
        coachId = coachId ?: "",
        color = color ?: "unknown",
        commercial = commercial ?: false,
        date = date ?: "unknown",
        description = description ?: "",
        endTime = endTime ?: "",
        isCancelled = isCancelled ?: false,
        name = name ?: "No Name",
        place = place ?: "unknown",
        serviceId = serviceId ?: "",
        startTime = startTime ?: "",
        tab = tab ?: "unknown",
        tabId = tabId ?: -1
    )
}