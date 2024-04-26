package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun AppAlertDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    description: String?,
    positiveButtonText: String,
    positiveButtonOnClick: () -> Unit,
    negativeButtonText: String,
    negativeButtonOnClick: () -> Unit,
    positiveButtonLoading: Boolean
) {
}