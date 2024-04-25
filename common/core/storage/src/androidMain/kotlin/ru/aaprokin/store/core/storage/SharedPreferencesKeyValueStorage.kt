package ru.aaprokin.store.core.storage

import android.content.Context

internal class SharedPreferencesKeyValueStorage(
    context: Context
) : KeyValueStorage {

    private val sharedPreferences = context.getSharedPreferences(
        "app_preferences",
        Context.MODE_PRIVATE
    )

    override fun get(key: Any): String? =
        sharedPreferences.getString(key.toString(), null)

    override fun set(key: Any, value: String?) {
        sharedPreferences.edit()
            .putString(key.toString(), value)
            .apply()
    }
}
