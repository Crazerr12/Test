package ru.aaprokin.store.feature.auth.presentation

import com.arkivanov.decompose.ComponentContext
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponentFactory
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponentFactory

interface AuthStoryComponentFactory {
    fun create(
        componentContext: ComponentContext,
        onAction: (AuthStoryComponentAction) -> Unit
    ): AuthStoryComponent
}

class AuthStoryComponentFactoryImpl(
    private val signInComponentFactory: SignInComponentFactory,
    private val registrationComponentFactory: RegistrationComponentFactory,
) : AuthStoryComponentFactory {
    override fun create(
        componentContext: ComponentContext,
        onAction: (AuthStoryComponentAction) -> Unit
    ) = AuthStoryComponent(
        componentContext = componentContext,
        signInComponentFactory = signInComponentFactory,
        registrationComponentFactory = registrationComponentFactory,
        onAction = onAction
    )
}
