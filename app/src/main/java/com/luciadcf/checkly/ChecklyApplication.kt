package com.luciadcf.checkly

import android.app.Application
import com.luciadcf.checkly.database.di.databaseModule
import com.luciadcf.checkly.feature.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChecklyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ChecklyApplication)

            modules(
                databaseModule,
                homeModule,
            )
        }
    }
}