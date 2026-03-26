package com.luciadcf.checkly.feature.home.domain.usecase

import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository

class AddHabitUseCase(private val repository: HabitRepository) {

    suspend operator fun invoke(name: String) {
        repository.insert(name)
    }
}