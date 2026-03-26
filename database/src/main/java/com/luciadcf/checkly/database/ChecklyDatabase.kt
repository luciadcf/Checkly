package com.luciadcf.checkly.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.luciadcf.checkly.database.dao.HabitDao
import com.luciadcf.checkly.database.entity.HabitEntity

@Database(entities = [HabitEntity::class], version = 1)
abstract class ChecklyDatabase : RoomDatabase() {
    abstract fun habitDao(): HabitDao
}