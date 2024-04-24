package ru.aaprokin.store.feature.auth.presentation.signIn

import com.arkivanov.decompose.ComponentContext
import ru.aaprokin.store.core.utils.presentation.StateHolder

private typealias SignInStateHolder = StateHolder<SignInState, SignInViewAction>

class SignInComponent(
    componentContext: ComponentContext,
    private val onAction: (SignInComponentAction) -> Unit
) : SignInStateHolder(InitialSignInState), ComponentContext by componentContext {
    override fun obtainViewAction(action: SignInViewAction) {
        when (action) {
            SignInViewAction.BackClicked -> onBackClick()
            SignInViewAction.PerformRegistration -> onRegistration()
        }
    }

    private fun onRegistration() {
        onAction(SignInComponentAction.PerformRegistration)
    }

    private fun onBackClick() {
        onAction(SignInComponentAction.Finished)
    }
}
