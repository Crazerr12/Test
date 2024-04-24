package ru.aaprokin.store.feature.auth.presentation.registration

import com.arkivanov.decompose.ComponentContext

interface RegistrationComponentFactory {
    fun create(
        componentContext: ComponentContext,
        onAction: (RegistrationComponentAction) -> Unit
    ): RegistrationComponent
}

class RegistrationComponentFactoryImpl : RegistrationComponentFactory {
    override fun create(
        componentContext: ComponentContext,
        onAction: (RegistrationComponentAction) -> Unit
    ) = RegistrationComponent(
        componentContext = componentContext,
        onAction = onAction
    )
}
