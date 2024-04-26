package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.aaprokin.store.core.compose.icons.AppIcons

@Composable
actual fun AppToolbar(
    modifier: Modifier,
    title: String?,
    navigationIcon: NavigationIcon,
    onNavigationClick: () -> Unit,
    extraContent: @Composable RowScope.() -> Unit
) {
    Row {
       Icon(painter =  AppIcons.EyeClose, contentDescription = null)

        title?.let {
            BasicText(text = title)
        }
    }
}


@Preview
@Composable
private fun AppToolbarPreview(){
    AppToolbar(
        modifier = Modifier,
        title = "awdawd",
        navigationIcon = NavigationIcon.Up,
        onNavigationClick = { /*TODO*/ },
        extraContent = { }
    )
}