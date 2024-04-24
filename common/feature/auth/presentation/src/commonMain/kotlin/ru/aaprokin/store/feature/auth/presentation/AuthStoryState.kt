package ru.aaprokin.store.feature.auth.presentation

data class AuthStoryState(
    val any: String // TODO Добавить состояния для AuthStoryView
)

internal val InitialAuthStoryState = AuthStoryState(
    any = "",
)
