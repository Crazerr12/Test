package ru.aaprokin.store.android

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.aaprokin.store.umbrella.android.umbrellaModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(umbrellaModule)
        }
    }
}
