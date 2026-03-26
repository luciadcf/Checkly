package com.luciadcf.checkly.feature.home.di

import com.luciadcf.checkly.feature.home.data.HabitRepositoryImpl
import com.luciadcf.checkly.feature.home.domain.repository.HabitRepository
import com.luciadcf.checkly.feature.home.domain.usecase.AddHabitUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.GetHabitsUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.RemoveHabitUseCase
import com.luciadcf.checkly.feature.home.domain.usecase.ToggleHabitUseCase
import com.luciadcf.checkly.feature.home.ui.home.HomeData
import com.luciadcf.checkly.feature.home.ui.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    // Repository
    single<HabitRepository> { HabitRepositoryImpl(get()) }

    // Use Cases
    factoryOf(::GetHabitsUseCase)
    factoryOf(::ToggleHabitUseCase)
    factoryOf(::AddHabitUseCase)
    factoryOf(::RemoveHabitUseCase)

    // Data
    factoryOf(::HomeData)

    // ViewModel
    viewModelOf(::HomeViewModel)
}