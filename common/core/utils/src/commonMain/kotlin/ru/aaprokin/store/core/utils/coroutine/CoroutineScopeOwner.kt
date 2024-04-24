package ru.aaprokin.store.core.utils.coroutine

import kotlinx.coroutines.CoroutineScope

interface CoroutineScopeOwner {

    val coroutineScope: CoroutineScope
}
