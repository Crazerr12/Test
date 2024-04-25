package ru.aaprokin.store.umbrella.android

import org.koin.dsl.module
import ru.aaprokin.store.core.mediator.mediatorModule
import ru.aaprokin.store.core.storage.androidStorageModule
import ru.aaprokin.store.core.utils.utilsModule

val umbrellaModule = module {
    includes(
//        androidMediatorModule,
        mediatorModule,
//        networkModule,
        androidStorageModule,
        utilsModule,
//        androidUtilsModule
    )
}
