package com.chilatesoftware.codechallenges_android.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.chilatesoftware.codechallenges_android.R as CodeChallengesResources

@Composable
fun TopBarComponent(title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(colorResource(CodeChallengesResources.color.primary_color)),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = title)
    }
}