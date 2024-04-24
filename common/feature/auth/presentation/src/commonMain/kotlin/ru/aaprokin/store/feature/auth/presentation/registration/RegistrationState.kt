package ru.aaprokin.store.feature.auth.presentation.registration

data class RegistrationState(
    val any: String // TODO Добавить состояния для RegistrationView
)

internal val InitialRegistrationState = RegistrationState(
    any = "",
)
