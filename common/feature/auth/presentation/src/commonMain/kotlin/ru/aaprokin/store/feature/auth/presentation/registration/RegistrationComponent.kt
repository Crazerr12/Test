package ru.aaprokin.store.feature.auth.presentation.registration

import com.arkivanov.decompose.ComponentContext
import ru.aaprokin.store.core.utils.presentation.StateHolder

private typealias RegistrationStateHolder = StateHolder<RegistrationState, RegistrationViewAction>

class RegistrationComponent(
    componentContext: ComponentContext,
    private val onAction: (RegistrationComponentAction) -> Unit
) : RegistrationStateHolder(InitialRegistrationState), ComponentContext by componentContext {
    override fun obtainViewAction(action: RegistrationViewAction) {
        when (action) {
            RegistrationViewAction.BackClicked -> onBackClick()
        }
    }

    private fun onBackClick() {
        onAction(RegistrationComponentAction.Finished)
    }
}
