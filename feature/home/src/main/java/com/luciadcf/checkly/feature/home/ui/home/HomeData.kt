package com.luciadcf.checkly.feature.home.ui.home

import com.luciadcf.checkly.feature.home.domain.model.Habit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeData {

    private val _uiState = MutableStateFlow(HomeState(LoadingStatus()))
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    fun updateHabits(habits: List<Habit>) {
        _uiState.update {
            it.copy(
                habits = habits,
                screenStatus = SuccessStatus()
            )
        }
    }

    fun error(message: String? = null) {
        _uiState.update {
            it.copy(
                screenStatus = ErrorStatus(message ?: "Error")
            )
        }
    }

    fun loading() {
        _uiState.update {
            it.copy(
                screenStatus = LoadingStatus()
            )
        }
    }

    fun updateAddSheetVisibility(visible: Boolean) {
        _uiState.update {
            it.copy(showAddSheet = visible)
        }
    }

}