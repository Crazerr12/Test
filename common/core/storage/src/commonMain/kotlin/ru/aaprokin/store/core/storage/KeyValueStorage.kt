package ru.aaprokin.store.core.storage

interface KeyValueStorage {

    operator fun get(key: Any): String?

    operator fun set(key: Any, value: String?)
}
