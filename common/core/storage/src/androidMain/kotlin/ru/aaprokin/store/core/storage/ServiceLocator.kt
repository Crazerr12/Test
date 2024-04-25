package ru.aaprokin.store.core.storage

import org.koin.dsl.module

val androidStorageModule = module {
    single<KeyValueStorage> {
        SharedPreferencesKeyValueStorage(get())
    }
}
