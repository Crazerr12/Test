package ru.aaprokin.store.feature.auth.presentation

sealed interface AuthStoryComponentAction {
    data object Finished : AuthStoryComponentAction
    // TODO Остальные действия компонента
}
