package ru.aaprokin.store.core.storage

import org.koin.dsl.module

val iosStorageModule = module {
    single<KeyValueStorage> {
        UserDefaultsKeyValueStorage()
    }
}
