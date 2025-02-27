package ru.aaprokin.store.core.compose.components

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.aaprokin.store.core.compose.icons.AppIcons

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
@Preview
@Composable
private fun ButtonPreview() {
    Surface {

    AppButton(label = "123", onClick = { })
    }

    AppIcons.EyeClose
}
