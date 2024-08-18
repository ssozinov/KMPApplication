package com.test.kmpapplication.utils

import androidx.compose.ui.graphics.Color
import com.test.kmpapplication.di.KoinInjector
import com.test.kmpapplication.domain.Models.FavouriteUI
import com.test.kmpapplication.domain.Models.Lesson

fun parseColor(colorString: String): Color {
    return try {
        val color = if (colorString.startsWith("#")) colorString.substring(1) else colorString
        val red = color.substring(0, 2).toInt(16)
        val green = color.substring(2, 4).toInt(16)
        val blue = color.substring(4, 6).toInt(16)
        Color(red, green, blue)
    } catch (e: Exception) {
        Color.Gray
    }
}

fun changesBaseUrl(newUrl: String) {
    KoinInjector.updateBaseUrl(newUrl)
}

fun List<FavouriteUI>.containsLesson(lesson: Lesson): Boolean {
    return this.any { favourite ->
        favourite.date == lesson.date &&
                favourite.startTime == lesson.startTime &&
                favourite.place == lesson.place
    }
}

fun Lesson.getFavouriteUI(favourites: List<FavouriteUI>): FavouriteUI {
    return favourites.first {
        it.trainingID == this.trainingID
    }
}