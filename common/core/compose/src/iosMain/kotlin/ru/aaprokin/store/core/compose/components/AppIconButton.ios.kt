package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun AppIconButton(
    modifier: Modifier,
    icon: DrawableResource,
    onClick: () -> Unit,
    iconTint: Color,
    backgroundTint: Color
) {
    AppIconButton(
        modifier = modifier,
        icon = painterResource(resource = icon),
        onClick = onClick,
        iconTint = iconTint,
        backgroundTint = backgroundTint
    )
}

@Composable
actual fun AppIconButton(
    modifier: Modifier,
    icon: Painter,
    onClick: () -> Unit,
    iconTint: Color,
    backgroundTint: Color
) {

}
