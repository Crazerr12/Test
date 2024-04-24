package ru.aaprokin.store.core.compose.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimens(
    val margin2: Dp,
    val margin4: Dp,
    val margin8: Dp,
    val margin12: Dp,
    val margin16: Dp,
    val margin24: Dp,
    val margin32: Dp,
)

internal val defaultDimens = AppDimens(
    margin2 = 2.dp,
    margin4 = 4.dp,
    margin8 = 8.dp,
    margin12 = 12.dp,
    margin16 = 16.dp,
    margin24 = 24.dp,
    margin32 = 32.dp
)
