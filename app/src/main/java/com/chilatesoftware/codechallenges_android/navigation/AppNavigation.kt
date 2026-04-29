package com.chilatesoftware.codechallenges_android.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chilatesoftware.codechallenges_android.ui.screens.ChallengeDetailScreen
import com.chilatesoftware.codechallenges_android.ui.screens.ChallengeListScreen
import com.chilatesoftware.codechallenges_android.ui.viewmodel.ChallengeViewModel

object Routes {
    const val LIST = "list"
    const val DETAIL = "detail"
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    viewModel: ChallengeViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LIST
    ) {
        composable(Routes.LIST) {
            val challenges by viewModel.challenges.collectAsState()

            ChallengeListScreen(
                challenges = challenges,
                onChallengeClick = { challenge ->
                    viewModel.selectChallenge(challenge)
                    navController.navigate(Routes.DETAIL)
                }
            )
        }

        composable(Routes.DETAIL) {
            val challenge by viewModel.selectedChallenge.collectAsState()

            challenge?.let {
                ChallengeDetailScreen(
                    challenge = it,
                    onBack = { navController.popBackStack() },
                    onAttemptChange = { attempt ->
                        viewModel.updateUserAttempt(it.id, attempt)
                    }
                )
            }
        }
    }
}