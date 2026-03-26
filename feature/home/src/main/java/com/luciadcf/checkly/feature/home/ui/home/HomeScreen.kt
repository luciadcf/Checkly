package com.luciadcf.checkly.feature.home.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.luciadcf.checkly.feature.home.ui.home.content.HomeContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeContent(
        state = uiState,
        onToggleHabit = { habit ->
            viewModel.onHabitCheckedChange(habit)
        },
        onAddHabitClick = {
            viewModel.onAddHabitClick()
        },
        onAddHabit = { name ->
            viewModel.onAddHabit(name)
        },
        onDismissAddHabit = {
            viewModel.onDismissAddHabit()
        },
    )
}