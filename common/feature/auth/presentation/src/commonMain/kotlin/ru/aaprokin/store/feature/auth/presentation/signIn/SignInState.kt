package ru.aaprokin.store.feature.auth.presentation.signIn

data class SignInState(
    val any: String // TODO Добавить состояния для SignInView
)

internal val InitialSignInState = SignInState(
    any = "",
)
