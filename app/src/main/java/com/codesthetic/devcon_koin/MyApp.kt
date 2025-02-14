package com.codesthetic.devcon_koin

import android.app.Application
import com.codesthetic.devcon_koin.di.combinedModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by razylvidal on September 28, 2023
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MyApp)
            // Load modules
            modules(combinedModules)
        }

    }
}
