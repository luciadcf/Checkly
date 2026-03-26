package com.luciadcf.checkly.feature.home.domain.model

data class Habit(
    val id: Long,
    val name: String,
    var isCompleted: Boolean
)