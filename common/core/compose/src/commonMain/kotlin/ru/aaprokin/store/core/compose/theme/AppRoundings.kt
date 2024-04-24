package ru.aaprokin.store.core.compose.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class AppRoundings(
    val shape8: RoundedCornerShape,
    val shape16: RoundedCornerShape,
)

internal val defaultRoundings = AppRoundings(
    shape8 = RoundedCornerShape(8.dp),
    shape16 = RoundedCornerShape(16.dp),
)
