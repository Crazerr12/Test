package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TODO описание
 */
@Composable
expect fun AppButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit,
    variant: AppButtonVariant = AppButtonVariant.Large
)

sealed interface AppButtonVariant {
    data object Small : AppButtonVariant
    data object Medium : AppButtonVariant
    data object Large : AppButtonVariant
}
