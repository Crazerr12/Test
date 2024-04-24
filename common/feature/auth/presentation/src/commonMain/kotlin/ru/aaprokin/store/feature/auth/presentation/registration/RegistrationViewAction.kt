package ru.aaprokin.store.feature.auth.presentation.registration

sealed interface RegistrationViewAction {
    data object BackClicked : RegistrationViewAction
    // TODO Остальные действия Registrationview
}
