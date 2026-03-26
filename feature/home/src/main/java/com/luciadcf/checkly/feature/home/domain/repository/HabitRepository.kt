package com.luciadcf.checkly.feature.home.domain.repository

import com.luciadcf.checkly.feature.home.domain.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository {
    fun getHabits(): Flow<List<Habit>>
    suspend fun insert(name: String)
    suspend fun update(habit: Habit)
    suspend fun remove(habit: Habit)
}