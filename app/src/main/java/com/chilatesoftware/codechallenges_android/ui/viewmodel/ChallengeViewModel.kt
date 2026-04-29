package com.chilatesoftware.codechallenges_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.chilatesoftware.codechallenges_android.model.CodeChallenge
import com.chilatesoftware.codechallenges_android.model.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ChallengeViewModel : ViewModel() {

    private val _challenges = MutableStateFlow(SampleData.challenges)
    val challenges: StateFlow<List<CodeChallenge>> = _challenges.asStateFlow()

    private val _selectedChallenge = MutableStateFlow<CodeChallenge?>(null)
    val selectedChallenge: StateFlow<CodeChallenge?> = _selectedChallenge.asStateFlow()

    fun selectChallenge(challenge: CodeChallenge) {
        _selectedChallenge.value = challenge
    }

    fun updateUserAttempt(challengeId: String, attempt: String) {
        _challenges.update { list ->
            list.map { if (it.id == challengeId) it.copy(userAttempt = attempt) else it }
        }
        // Sincroniza también el challenge seleccionado
        if (_selectedChallenge.value?.id == challengeId) {
            _selectedChallenge.update { it?.copy(userAttempt = attempt) }
        }
    }
}