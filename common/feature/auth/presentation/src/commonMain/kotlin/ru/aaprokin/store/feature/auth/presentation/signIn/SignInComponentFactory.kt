package ru.aaprokin.store.feature.auth.presentation.signIn

import com.arkivanov.decompose.ComponentContext

interface SignInComponentFactory {
    fun create(
        componentContext: ComponentContext,
        onAction: (SignInComponentAction) -> Unit
    ): SignInComponent
}

class SignInComponentFactoryImpl : SignInComponentFactory {
    override fun create(
        componentContext: ComponentContext,
        onAction: (SignInComponentAction) -> Unit
    ) = SignInComponent(
        componentContext = componentContext,
        onAction = onAction
    )
}
