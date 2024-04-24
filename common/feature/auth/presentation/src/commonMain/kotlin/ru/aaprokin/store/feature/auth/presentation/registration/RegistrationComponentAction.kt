package ru.aaprokin.store.feature.auth.presentation.registration

sealed interface RegistrationComponentAction {
    data object Finished : RegistrationComponentAction
    // TODO Остальные действия компонента
}
