package com.luciadcf.checkly.feature.home.ui.home.content.success

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.ui.home.HomeState
import com.luciadcf.checkly.feature.home.ui.home.content.success.component.AddHabitBottomSheet
import com.luciadcf.checkly.feature.home.ui.home.content.success.component.EmptyState
import com.luciadcf.checkly.feature.home.ui.home.content.success.component.HabitList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuccessContent(
    state: HomeState,
    paddingValues: PaddingValues,
    onToggleHabit: (Habit) -> Unit,
    onAddHabit: (String) -> Unit,
    onDismissAddHabit: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()

    if (state.habits.isEmpty()) {
        EmptyState(modifier = Modifier.padding(paddingValues))
    } else {
        HabitList(
            habits = state.habits,
            onHabitCheckedChange = onToggleHabit,
            modifier = Modifier.padding(paddingValues)
        )
    }

    if (state.showAddSheet) {
        ModalBottomSheet(
            onDismissRequest = { onDismissAddHabit() },
            sheetState = sheetState,
            containerColor = MaterialTheme.colorScheme.surface, // Usará tu color oscuro/claro
            dragHandle = { BottomSheetDefaults.DragHandle() } // La rayita de arriba
        ) {
            AddHabitBottomSheet(
                onDismiss = { onDismissAddHabit() },
                onConfirm = { onAddHabit(it) }
            )
        }
    }
}