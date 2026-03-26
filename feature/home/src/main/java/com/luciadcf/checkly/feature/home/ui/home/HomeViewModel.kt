package com.luciadcf.checkly.feature.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.domain.usecase.AddHabitUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.GetHabitsUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.RemoveHabitUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.ToggleHabitUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val data: HomeData,
    private val getHabitsUseCase: GetHabitsUseCase,
    private val toggleHabitUseCase: ToggleHabitUseCase,
    private val addHabitUseCase: AddHabitUseCase,
    private val removeHabitUseCase: RemoveHabitUseCase
) : ViewModel() {

    val uiState = data.uiState

    init {
        observeHabits()
    }

    private fun observeHabits() {
        viewModelScope.launch {
            getHabitsUseCase().catch { e ->
                data.error(e.message)
            }.collect { habits ->
                data.updateHabits(habits)
            }
        }
    }

    fun onHabitCheckedChange(habit: Habit) {
        viewModelScope.launch {
            toggleHabitUseCase(habit)
        }
    }

    fun onAddHabitClick() {
        data.updateAddSheetVisibility(true)
    }

    fun onDismissAddHabit() {
        data.updateAddSheetVisibility(false)
    }

    fun onAddHabit(name: String) {
        viewModelScope.launch {
            addHabitUseCase(name)
            data.updateAddSheetVisibility(false)
        }
    }
}