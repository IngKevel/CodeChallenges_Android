package com.chilatesoftware.codechallenges_android.model

data class CodeChallenge(
    val id: String = "",
    val title: String = "",
    val difficulty: Difficulty = Difficulty.EASY,
    val question: String = "",
    val starterCode: String = "",
    val solution: String = "",
    val userAttempt: String = ""
)

enum class Difficulty {
    EASY, MEDIUM, HARD
}
