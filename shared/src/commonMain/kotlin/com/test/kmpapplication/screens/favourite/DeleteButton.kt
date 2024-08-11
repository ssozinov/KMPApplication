package com.test.kmpapplication.screens.favourite

import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.kmpapplication.strings.KMPResourceStrings

@Composable
fun DeleteAllButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier.height(50.dp),
        onClick = onClick
    ) {
        Text(
            text = KMPResourceStrings.delete_all,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp
        )
    }
}
