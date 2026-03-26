package com.luciadcf.checkly.feature.home.domain.usecase

import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository

class RemoveHabitUseCase(private val repository: HabitRepository) {

    suspend operator fun invoke(habit: Habit) {
        repository.remove(habit)
    }
}