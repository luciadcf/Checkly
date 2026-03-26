package com.luciadcf.checkly.feature.home.domain.usecase

import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow

class GetHabitsUseCase(private val repository: HabitRepository) {
    operator fun invoke(): Flow<List<Habit>> = repository.getHabits()
}