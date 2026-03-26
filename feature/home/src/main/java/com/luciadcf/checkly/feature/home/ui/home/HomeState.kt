package com.luciadcf.checkly.feature.home.ui.home

import com.luciadcf.checkly.feature.home.domain.model.Habit

data class HomeState(
    val screenStatus: HomeScreenStatus = LoadingStatus(),
    val habits: List<Habit> = emptyList(),
    val showAddSheet: Boolean = false,
)