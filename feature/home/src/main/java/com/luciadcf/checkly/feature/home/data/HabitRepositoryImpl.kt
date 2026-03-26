package com.luciadcf.checkly.feature.home.data

import com.luciadcf.checkly.database.dao.HabitDao
import com.luciadcf.checkly.database.entity.HabitEntity
import com.luciadcf.checkly.feature.home.data.mapper.toDomain
import com.luciadcf.checkly.feature.home.data.mapper.toEntity
import com.luciadcf.checkly.feature.home.domain.model.Habit
import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HabitRepositoryImpl(private val dao: HabitDao) : HabitRepository {
    override fun getHabits(): Flow<List<Habit>> =
        dao.getAll().map { entities ->
            entities.map { it.toDomain() }
        }

    override suspend fun insert(name: String) {
        dao.insert(HabitEntity(name = name))
    }

    override suspend fun update(habit: Habit) {
        dao.update(habit.toEntity())
    }

    override suspend fun remove(habit: Habit) {
        dao.delete(habit.toEntity())
    }
}