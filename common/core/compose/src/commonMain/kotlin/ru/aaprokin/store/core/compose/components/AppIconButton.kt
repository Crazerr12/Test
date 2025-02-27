@file:OptIn(ExperimentalResourceApi::class)

package ru.aaprokin.store.core.compose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import ru.aaprokin.store.core.compose.theme.AppTheme

@Composable
expect fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    onClick: () -> Unit,
    iconTint: Color = AppTheme.Colors.iconPrimary,
    backgroundTint: Color = AppTheme.Colors.surfacePrimary
)

@Composable
expect fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit,
    iconTint: Color = AppTheme.Colors.iconPrimary,
    backgroundTint: Color = AppTheme.Colors.surfacePrimary
)
