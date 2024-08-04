package com.test.kmpapplication.data.a.DTO


import kotlinx.serialization.Serializable

@Serializable
data class TrainingDTO(
    val lessons: List<LessonDTO?>?,
    val option: OptionDTO?,
    val tabs: List<TabDTO?>?,
    val trainers: List<TrainerDTO?>?
)