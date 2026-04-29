package com.chilatesoftware.codechallenges_android.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chilatesoftware.codechallenges_android.model.CodeChallenge
import com.chilatesoftware.codechallenges_android.model.Difficulty

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeListScreen(
    challenges: List<CodeChallenge>,
    onChallengeClick: (CodeChallenge) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis Code Challenges") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(innerPadding)
        ) {
            items(challenges) { challenge ->
                ChallengeCard(
                    challenge = challenge,
                    onClick = { onChallengeClick(challenge) }
                )
            }
        }
    }
}

@Composable
fun ChallengeCard(challenge: CodeChallenge, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = challenge.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = challenge.question.take(60) + "...",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            DifficultyBadge(difficulty = challenge.difficulty)
        }
    }
}

@Composable
fun DifficultyBadge(difficulty: Difficulty) {
    val (label, color) = when (difficulty) {
        Difficulty.EASY -> "Fácil" to MaterialTheme.colorScheme.tertiary
        Difficulty.MEDIUM -> "Medio" to MaterialTheme.colorScheme.primary
        Difficulty.HARD -> "Difícil" to MaterialTheme.colorScheme.error
    }
    Surface(
        color = color.copy(alpha = 0.15f),
        shape = MaterialTheme.shapes.small
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            style = MaterialTheme.typography.labelSmall,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}