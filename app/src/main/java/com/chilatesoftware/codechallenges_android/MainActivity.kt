package com.chilatesoftware.codechallenges_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.chilatesoftware.codechallenges_android.ui.screens.ChallengeListScreen
import com.chilatesoftware.codechallenges_android.ui.theme.CodeChallenges_AndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeChallenges_AndroidTheme {
                ChallengeListScreen(onChallengeClick = { /* siguiente tarea */ })
            }
        }
    }
}