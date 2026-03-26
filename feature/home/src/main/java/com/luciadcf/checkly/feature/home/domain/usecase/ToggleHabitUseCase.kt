package com.luciadcf.checkly.feature.home.domain.usecase

import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository

class ToggleHabitUseCase(private val repository: HabitRepository) {

    suspend operator fun invoke(habit: Habit) {
        val updatedHabit = habit.copy(isCompleted = !habit.isCompleted)
        repository.update(updatedHabit)
    }
}