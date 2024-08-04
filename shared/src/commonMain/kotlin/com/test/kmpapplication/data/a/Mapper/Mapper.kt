package com.test.kmpapplication.data.a.Mapper

import com.test.kmpapplication.data.a.DTO.LessonDTO
import com.test.kmpapplication.data.a.DTO.TrainerDTO
import com.test.kmpapplication.data.a.DTO.TrainingDTO

import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.domain.Models.Trainer
import com.test.kmpapplication.domain.Models.TrainingInfo

fun TrainingDTO.toTraningInfo(): TrainingInfo {
    val trainersList = trainers?.filterNotNull()?.map { it.toTrainers() } ?: listOf()
    return TrainingInfo(
        lessons = lessons?.filterNotNull()!!.map { it.toLesson(trainers = trainersList) },
        trainers = trainers?.filterNotNull()!!.map{ it.toTrainers ()}
    )
}

fun LessonDTO.toLesson(trainers: List<Trainer>): Lesson {
    val trainerImage = trainers.find { it.id == coachId }?.imageUrl ?: ""
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
        tabId = tabId ?: -1,
        trainerImage = trainerImage
    )
}
fun TrainerDTO.toTrainers(): Trainer {
    return Trainer(
        description = description ?: "",
        fullName = fullName ?: "",
        id = id ?: "",
        imageUrl = imageUrl ?: "",
        imageUrlSmall = imageUrlSmall ?: "",
        imageUrlMedium = imageUrlMedium ?: "",
        lastName = lastName ?: "",
        name = name ?: "",
        position = position ?: ""
    )
}
