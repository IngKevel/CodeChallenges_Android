package com.chilatesoftware.codechallenges_android.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chilatesoftware.codechallenges_android.model.CodeChallenge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeDetailScreen(
    challenge: CodeChallenge,
    onBack: () -> Unit,
    onAttemptChange: (String) -> Unit
) {
    var showSolution by remember { mutableStateOf(false) }
    var userAttempt by remember { mutableStateOf(challenge.starterCode) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = challenge.title,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            // Badge de dificultad
            DifficultyBadge(difficulty = challenge.difficulty)

            // Sección: Pregunta
            SectionCard(title = "Pregunta") {
                Text(
                    text = challenge.question,
                    style = MaterialTheme.typography.bodyMedium,
                    lineHeight = 22.sp
                )
            }

            // Sección: Codigo
            SectionCard(title = "Codigo") {
                OutlinedTextField(
                    value = userAttempt,
                    onValueChange = { userAttempt = it
                        onAttemptChange(it)
                                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 160.dp),
                    textStyle = LocalTextStyle.current.copy(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 13.sp
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
            }

            // Sección: Solución
            SectionCard(title = "Solución") {
                if (showSolution) {
                    CodeBlock(code = challenge.solution)
                    Spacer(modifier = Modifier.height(8.dp))
                }
                OutlinedButton(
                    onClick = { showSolution = !showSolution },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = if (showSolution) Icons.Default.Lock
                        else Icons.Default.Done,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (showSolution) "Ocultar solución" else "Revelar solución")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

// Contenedor reutilizable para cada sección
@Composable
fun SectionCard(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
            )
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                content()
            }
        }
    }
}

// Bloque de código con scroll horizontal
@Composable
fun CodeBlock(code: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(8.dp)
            )
            .horizontalScroll(rememberScrollState())
            .padding(12.dp)
    ) {
        Text(
            text = code,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}