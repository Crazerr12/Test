package ru.aaprokin.store.core.mediator

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.Serializable
import ru.aaprokin.store.core.utils.coroutine.CoroutineScopeOwner
import ru.aaprokin.store.core.utils.coroutine.componentCoroutineScope
import ru.aaprokin.store.core.utils.toast.ToastState
import ru.aaprokin.store.core.utils.toast.toastManager
import ru.aaprokin.store.feature.auth.presentation.AuthStoryComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    val toast: Value<ToastState>

    fun onBackClicked(toIndex: Int)

    sealed interface Child {
        data class AuthChild(val component: AuthStoryComponent) : Child
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object AuthStory : Config
    }

    interface Factory {
        fun create(componentContext: ComponentContext): RootComponent
    }
}

internal class RootComponentImpl(
    private val componentContext: ComponentContext,
    private val initialConfigurationResolver: InitialConfigurationResolver
) : RootComponent, CoroutineScopeOwner, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootComponent.Config>()

    private val di: InternalComponent by lazy {
        InternalComponent.create()
    }

    private val toastManager = toastManager().also {
        it.attach(this)
    }


//    @Suppress("UnusedPrivateProperty")
//    private val messageReceiverComponent = di.messageReceiverComponentFactory.create(
//        componentContext = childContext(key = "messageReceiver")
//    )

    override val toast: Value<ToastState> get() = toastManager.toast

    override val stack: Value<ChildStack<RootComponent.Config, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = RootComponent.Config.serializer(),
        initialConfiguration = initialConfigurationResolver.resolve(),
        handleBackButton = true,
        childFactory = ::child
    )

    override val coroutineScope: CoroutineScope = componentCoroutineScope()

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private fun child(
        config: RootComponent.Config,
        componentContext: ComponentContext
    ): RootComponent.Child =
        when (config) {
            RootComponent.Config.AuthStory -> RootComponent.Child.AuthChild(
                di.authStoryComponentFactory.create(
                    componentContext = componentContext,
                    onAction = {

                    }
                )
            )


        }

    class FactoryImpl(
        private val initialConfigurationResolver: InitialConfigurationResolver
    ) : RootComponent.Factory {
        override fun create(componentContext: ComponentContext): RootComponent =
            RootComponentImpl(
                componentContext = componentContext,
                initialConfigurationResolver = initialConfigurationResolver
            )
    }
}
