package com.luciadcf.checkly.feature.home.data.mapper

import com.luciadcf.checkly.database.entity.HabitEntity
import com.luciadcf.checkly.feature.home.domain.model.Habit

fun HabitEntity.toDomain() = Habit(
    id = id,
    name = name,
    isCompleted = isCompleted
)

fun Habit.toEntity(): HabitEntity = HabitEntity(
    id = id,
    name = name,
    isCompleted = isCompleted
)