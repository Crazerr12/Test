package ru.store.umbrela.ios

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import platform.UIKit.UIViewController
import ru.aaprokin.store.core.mediator.RootComponent
import ru.aaprokin.store.core.mediator.RootCoordinator
import ru.aaprokin.store.core.mediator.mediatorModule
import ru.aaprokin.store.core.storage.iosStorageModule
import ru.aaprokin.store.core.utils.utilsModule

fun initKoin() {
    startKoin {
        modules(
            mediatorModule,
//            networkModule,
            iosStorageModule,
            utilsModule,
//            iosUtilsModule
        )
    }
}

class IosRootComponent : KoinComponent {
    val rootComponentFactory: RootComponent.Factory by inject()

    fun create(lifecycleRegistry: LifecycleRegistry): RootComponent =
        rootComponentFactory.create(DefaultComponentContext(lifecycleRegistry))
}

fun MainViewController(component: RootComponent): UIViewController {
    return ComposeUIViewController {
        RootCoordinator(rootComponent = component)
    }
}
