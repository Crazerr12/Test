package ru.aaprokin.store.feature.auth.presentation.signIn

sealed interface SignInViewAction {
    data object BackClicked : SignInViewAction
    data object PerformRegistration : SignInViewAction
    // TODO Остальные действия SignInview
}
