package com.test.kmpapplication.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import coil3.compose.rememberAsyncImagePainter
import com.test.kmpapplication.domain.Models.Lesson
import com.test.kmpapplication.utils.changesBaseUrl
import com.test.kmpapplication.utils.parseColor


class MainScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { MainViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        var showDialog by remember { mutableStateOf(false) }
        var selectedTraining by remember { mutableStateOf<Lesson?>(null) }
        LaunchedEffect(viewModel) {
            viewModel.getAllTrainings()
        }
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 20.dp),
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(state.trainings.lessons) {

                    val cardColor = parseColor(it.color)
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).clickable {
                            changesBaseUrl("https://test-changes.com/")
                            selectedTraining = it
                            showDialog = true
                        }
                            .background(color = Color.Transparent),
                        shape = RoundedCornerShape(12.dp),
                        backgroundColor = cardColor,

                        ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(7.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(it.trainerImage),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(64.dp).clip(
                                    CircleShape
                                ),
                                alpha = DefaultAlpha
                            )
                            Column(modifier = Modifier.padding(start = 8.dp).weight(1f)) {
                                Text(
                                    text = it.date + " " + it.startTime,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 5.dp)
                                )

                                Text(
                                    text = it.tab,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 5.dp)
                                )

                                Text(
                                    text = it.place,
                                    fontWeight = FontWeight.W500,
                                    fontSize = 14.sp,
                                    maxLines = 4,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.padding(top = 5.dp)
                                )
                            }
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "Add to favorites",
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.CenterVertically)
                                    .clickable {
                                        viewModel.insertInFavorites(it)
                                    }
                            )
                        }
                    }
                }
            }
            AnimatedVisibility(
                visible = showDialog,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0x80000000))
                        .clickable {
                            showDialog = false
                        },
                    contentAlignment = Alignment.Center
                ) {
                    selectedTraining?.let { training ->
                        DialogContent(training = training, onDismiss = { showDialog = false })
                    }
                }
            }
        }
    }

    @Composable
    fun DialogContent(training: Lesson, onDismiss: () -> Unit) {
        Card(
            shape = RoundedCornerShape(12.dp),
            backgroundColor = Color.White,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Информация о тренировке",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Дата: ${training.date} ${training.startTime}")
                Text(text = "Место: ${training.place}")
                Text(text = "Тип: ${training.tab}")

                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onDismiss() }) {
                    Text(text = "Закрыть")
                }

            }
        }
    }
}