package ru.aaprokin.store.core.utils

import org.koin.dsl.module
import ru.aaprokin.store.core.utils.toast.ToastManager

val utilsModule = module {
    single { ToastManager() }
//    single { MessageBus() }
}
