package com.test.kmpapplication.screens.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen

class FavouriteScreen:Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { FavouriteViewModel() }
        val state by viewModel.stateFlow.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.loadTrainings()
        }
        Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                contentPadding = PaddingValues(
                    top = 30.dp, bottom = 90.dp
                )
            ) {
                items(state.items) {
                    FavouriteItem(it) {
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = {
                                viewModel.deleteItem(it.id.toLong())
                            },
                        ) {
                            Icon(contentDescription = null, imageVector = Icons.Default.Delete)
                        }

                    }
                }
            }
            DeleteAllButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, end = 16.dp, bottom = 40.dp),
                onClick = {
                    viewModel.clearTrainings()
                }
            )
        }
    }
}

