package com.luciadcf.checkly.database.di

import androidx.room.Room
import com.luciadcf.checkly.database.ChecklyDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    // 1. Proveer la instancia de la Base de Datos (Singleton)
    single {
        Room.databaseBuilder(
            androidContext(),
            ChecklyDatabase::class.java,
            "checkly_database" // Nombre del archivo .db
        )
            .fallbackToDestructiveMigration(false) // Útil en desarrollo para no manejar migraciones aún
            .build()
    }

    // 2. Proveer los DAOs individualmente
    // Esto permite que el repositorio pida 'HabitDao' sin saber nada de la base de datos
    single { get<ChecklyDatabase>().habitDao() }
}