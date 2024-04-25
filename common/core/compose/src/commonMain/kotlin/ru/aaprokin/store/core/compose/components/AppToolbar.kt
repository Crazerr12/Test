package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: String?,
    navigationIcon: NavigationIcon = NavigationIcon.Up,
    onNavigationClick: () -> Unit,
    extraContent: @Composable RowScope.() -> Unit = { },
) = Unit

sealed interface NavigationIcon {
    data object Up : NavigationIcon
    data object Close : NavigationIcon
}
