package ru.aaprokin.store.core.mediator

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.aaprokin.store.core.utils.utilsModule
import ru.aaprokin.store.feature.auth.presentation.AuthStoryComponentFactory
import ru.aaprokin.store.feature.auth.presentation.authPresentationModule

val mediatorModule = module {
    single<RootComponent.Factory> {
        RootComponentImpl.FactoryImpl(
            InitialConfigurationResolver()
        )
    }
}

internal val internalModule = module {
    includes(
        utilsModule,
        authPresentationModule,
//        projectsPresentationModule,
//        profilePresentationModule,
//        dashboardsPresentationModule,
//        messagesPresentationModule,
//        devToolsPresentationModule,
//        notificationsPresentationModule,
    )
}

internal class InternalComponent : KoinComponent {
    val authStoryComponentFactory: AuthStoryComponentFactory by inject()
//    val projectBrowserStoryComponentFactory: ProjectBrowserStoryComponentFactory by inject()
//    val profileStoryComponentFactory: ProfileStoryComponentFactory by inject()
//    val messageReceiverComponentFactory: MessageReceiverComponentFactory by inject()
//    val notificationsBrowserStoryComponentFactory: NotificationsBrowserStoryComponentFactory by inject()

    companion object {
        fun create(): InternalComponent {
            loadKoinModules(internalModule)
            return InternalComponent()
        }
    }
}
