package com.test.kmpapplication.data.api.DTO

import kotlinx.serialization.Serializable

@Serializable
data class TrainingInfoDTO(
    val lessons: List<LessonDTO?>?,
    val option: OptionDTO?,
    val tabs: List<TabDTO?>?,
    val trainers: List<TrainerDTO?>?
)