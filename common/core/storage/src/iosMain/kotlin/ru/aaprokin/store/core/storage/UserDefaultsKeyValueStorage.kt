package ru.aaprokin.store.core.storage

import platform.Foundation.NSUserDefaults

class UserDefaultsKeyValueStorage : KeyValueStorage {

    private val container = NSUserDefaults.standardUserDefaults

    override fun get(key: Any): String? =
        container.stringForKey(key.toString())

    override fun set(key: Any, value: String?) {
        if (value != null) {
            container.setObject(value, key.toString())
        } else {
            container.removeObjectForKey(key.toString())
        }
    }
}
