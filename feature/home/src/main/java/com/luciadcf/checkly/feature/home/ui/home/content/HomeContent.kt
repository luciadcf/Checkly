package com.luciadcf.checkly.feature.home.ui.home.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.ui.home.ErrorStatus
import com.luciadcf.checkly.feature.home.ui.home.HomeState
import com.luciadcf.checkly.feature.home.ui.home.LoadingStatus
import com.luciadcf.checkly.feature.home.ui.home.SuccessStatus
import com.luciadcf.checkly.feature.home.ui.home.content.error.ErrorContent
import com.luciadcf.checkly.feature.home.ui.home.content.loading.LoadingContent
import com.luciadcf.checkly.feature.home.ui.home.content.success.SuccessContent
import com.luciadcf.checkly.feature.home.ui.home.strings.HomeStringKeys

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    state: HomeState,
    onToggleHabit: (Habit) -> Unit,
    onAddHabitClick: () -> Unit,
    onAddHabit: (String) -> Unit,
    onDismissAddHabit: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        HomeStringKeys.AppName.value(),
                        fontWeight = FontWeight.ExtraBold, // Un título con fuerza
                        letterSpacing = (-0.5).sp // Estética moderna
                    )
                },
                colors = topAppBarColors(
                    containerColor = Color.Transparent, // Se funde con el fondo
                    scrolledContainerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onBackground
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddHabitClick() }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Añadir hábito")
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(horizontal = 16.dp)) {
            when (state.screenStatus) {
                is LoadingStatus -> {
                    LoadingContent(paddingValues)
                }

                is ErrorStatus -> {
                    ErrorContent(state.screenStatus.error, paddingValues)
                }

                is SuccessStatus -> {
                    SuccessContent(
                        state = state,
                        paddingValues = paddingValues,
                        onToggleHabit = onToggleHabit,
                        onAddHabit = onAddHabit,
                        onDismissAddHabit = onDismissAddHabit
                    )
                }
            }
        }
    }
}