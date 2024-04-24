package ru.aaprokin.store.feature.auth.presentation

sealed interface AuthStoryViewAction {
    data object BackClicked : AuthStoryViewAction
    // TODO Остальные действия AuthStoryview
}
