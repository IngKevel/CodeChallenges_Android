package com.chilatesoftware.codechallenges_android.presentation.pages.home_page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chilatesoftware.codechallenges_android.presentation.components.TopBarComponent
import com.chilatesoftware.codechallenges_android.R as CodeChallengesResources

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopBarComponent(title = "Home Page") }
    ) { paddingValues ->
        Text(
            text = stringResource(id = CodeChallengesResources.string.app_name),
            modifier = modifier.padding(paddingValues)
        )
    }
}