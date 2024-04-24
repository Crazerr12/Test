package ru.aaprokin.store.core.utils.presentation

import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

abstract class StateHolder<S : Any, VA>(
    initialValue: S
) {
    private var _state: MutableValue<S> = MutableValue(initialValue)
    val state: Value<S> = _state

    fun reduceState(reducer: S.() -> S) {
        _state.value = reducer.invoke(_state.value)
    }

    abstract fun obtainViewAction(action: VA)
}
