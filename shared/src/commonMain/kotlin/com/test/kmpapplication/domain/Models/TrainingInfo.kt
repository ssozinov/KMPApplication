package com.test.kmpapplication.domain.Models


data class TrainingInfo(
    val lessons: List<Lesson>,
    //val option: Option,
    //val tabs: List<Tab>,
    val trainers: List<Trainer>
)