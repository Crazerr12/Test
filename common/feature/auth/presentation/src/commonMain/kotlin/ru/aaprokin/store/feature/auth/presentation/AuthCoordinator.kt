package ru.aaprokin.store.feature.auth.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationView
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInView

@Composable
fun AuthCoordinator(
    component: AuthStoryComponent,
    modifier: Modifier = Modifier
) {
    Children(
        stack = component.stack,
        modifier = modifier
    ) {
        when (val child = it.instance) {
            is AuthStoryComponent.Child.SignInChild ->
                SignInView(component = child.component)

            is AuthStoryComponent.Child.RegistrationChild ->
                RegistrationView(component = child.component)
        }
    }
}
