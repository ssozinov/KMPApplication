package com.test.kmpapplication.domain.Models

data class FavouriteUI (
    val id: Int,
    val startTime: String,
    val date: String,
    val place: String,
    val tab: String,
    val trainerImage: String,
    val trainingID: String
){
    companion object Default{
        val favouriteUI = FavouriteUI(
            id = 0,
            startTime = "",
            date = "",
            place = "",
            tab = "",
            trainerImage = "",
            trainingID = ""
        )
    }
}
