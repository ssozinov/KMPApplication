package com.test.kmpapplication.screens.trainers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.test.kmpapplication.utils.parseColor

class TrainerScreen(private val clubId:String) : Screen {

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { TrainerViewModel() }
        val state by viewModel.stateFlow.collectAsState()
        LaunchedEffect(viewModel){
            viewModel.getTrainers(clubId  = clubId)
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 20.dp),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(state.trainers) {

                Card(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)
                        .background(color = Color.Transparent),
                    shape = RoundedCornerShape(12.dp),

                    ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(it.imageUrlMedium),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(128.dp).clip(
                                CircleShape
                            ),
                            alpha = DefaultAlpha
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(
                                text = it.fullName,
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 5.dp)
                            )

                            Text(
                                text = it.description,
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 5.dp)
                            )

                            Text(
                                text = it.position,
                                fontWeight = FontWeight.W500,
                                fontSize = 14.sp,
                                maxLines = 4,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}