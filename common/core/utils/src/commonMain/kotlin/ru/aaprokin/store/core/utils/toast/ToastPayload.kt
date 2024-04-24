package ru.aaprokin.store.core.utils.toast

private const val DefaultDurationMillis = 4000

data class ToastPayload<T>(
    val message: T? = null,
    val durationMillis: Int = DefaultDurationMillis,
    val level: ToastLevel = ToastLevel.Success
)

enum class ToastLevel {
    Success,
    Danger
}
