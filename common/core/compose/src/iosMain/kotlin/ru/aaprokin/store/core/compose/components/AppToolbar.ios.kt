package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.aaprokin.store.core.compose.theme.AppTheme

@Composable
actual fun AppToolbar(
    modifier: Modifier,
    title: String?,
    navigationIcon: NavigationIcon,
    onNavigationClick: () -> Unit,
    extraContent: @Composable RowScope.() -> Unit
) {
    AppTheme.TextStyles.text1
}