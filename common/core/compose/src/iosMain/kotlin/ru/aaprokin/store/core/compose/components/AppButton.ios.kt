package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TODO описание
 */
@Composable
actual fun AppButton(
    modifier: Modifier,
    label: String,
    enabled: Boolean,
    loading: Boolean,
    onClick: () -> Unit,
    variant: AppButtonVariant
) {
}