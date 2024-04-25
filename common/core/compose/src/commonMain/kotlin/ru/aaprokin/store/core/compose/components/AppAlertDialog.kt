package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppAlertDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    title: String,
    description: String? = null,
    positiveButtonText: String,
    positiveButtonOnClick: () -> Unit = {},
    negativeButtonText: String,
    negativeButtonOnClick: () -> Unit = {},
    positiveButtonLoading: Boolean = false,
) = Unit
