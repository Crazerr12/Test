package ru.aaprokin.store.feature.auth.presentation.signIn

sealed interface SignInComponentAction {
    data object Finished : SignInComponentAction
   data object PerformRegistration : SignInComponentAction
    // TODO Остальные действия компонента
}
