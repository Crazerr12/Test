package ru.aaprokin.store.feature.auth.presentation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponent
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponentAction
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponentFactory
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponent
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponentAction
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponentFactory

class AuthStoryComponent(
    componentContext: ComponentContext,
    private val signInComponentFactory: SignInComponentFactory,
    private val registrationComponentFactory: RegistrationComponentFactory,
    private val onAction: (AuthStoryComponentAction) -> Unit
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    val stack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.SignIn,
        handleBackButton = true,
        childFactory = ::child
    )

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            Config.SignIn -> createSignInChild(componentContext)
            Config.Registration -> createRegistrationChild(componentContext)
        }

    fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private fun createSignInChild(componentContext: ComponentContext) =
        Child.SignInChild(
            component = signInComponentFactory.create(
                componentContext = componentContext,
                onAction = { action ->
                    when (action) {
                        SignInComponentAction.PerformRegistration -> navigation.push(Config.Registration)
                        else -> Unit
                    }
                }
            )
        )

    private fun createRegistrationChild(componentContext: ComponentContext) =
        Child.RegistrationChild(
            component = registrationComponentFactory.create(
                componentContext = componentContext,
                onAction = { action ->
                    when (action) {
                        RegistrationComponentAction.Finished -> navigation.pop()
                    }
                }
            )
        )


    sealed interface Child {
        data class SignInChild(val component: SignInComponent) : Child
        data class RegistrationChild(val component: RegistrationComponent) : Child
    }


    @Serializable
    sealed interface Config {
        data object SignIn : Config
        data object Registration : Config
//        data object Registration : Config
//        data object AccountBanned : Config
    }
}
