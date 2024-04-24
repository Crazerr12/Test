package ru.aaprokin.store.core.utils.platform

interface Platform {

    val os: String

    val version: String

    val build: String

    val deviceId: String

    val language: String

    val isDebug: Boolean
}
