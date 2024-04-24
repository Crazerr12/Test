package ru.aaprokin.store.core.utils.presentation

import com.arkivanov.decompose.ComponentContext

interface ComponentFactory<Component, Action> {
    fun create(
        componentContext: ComponentContext,
        onAction: (Action) -> Unit
    ): Component
}
