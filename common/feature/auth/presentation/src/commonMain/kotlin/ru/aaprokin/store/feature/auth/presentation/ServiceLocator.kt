package ru.aaprokin.store.feature.auth.presentation

import org.koin.dsl.module
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponentFactory
import ru.aaprokin.store.feature.auth.presentation.registration.RegistrationComponentFactoryImpl
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponentFactory
import ru.aaprokin.store.feature.auth.presentation.signIn.SignInComponentFactoryImpl

val authPresentationModule = module {
    single<AuthStoryComponentFactory> {
        AuthStoryComponentFactoryImpl(get(),get())
    }
    single<SignInComponentFactory> {
        SignInComponentFactoryImpl()
    }
    single<RegistrationComponentFactory> {
        RegistrationComponentFactoryImpl()
    }
//    includes(authDataModule, authDomainModule)
}
