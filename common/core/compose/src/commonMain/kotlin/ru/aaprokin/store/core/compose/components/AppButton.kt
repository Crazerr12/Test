package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * TODO описание
 */
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    label: String,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit,
    variant: AppButtonVariant = AppButtonVariant.Large
) {
    // TODO
    Box(modifier = Modifier.then(modifier)) {
        BasicText(
            text = label,
//            style = AppTheme.TextStyles.buttonM // Из-за шрифта в не будет работать превью
        )
    }
}

sealed interface AppButtonVariant {
    data object Small : AppButtonVariant
    data object Medium : AppButtonVariant
    data object Large : AppButtonVariant
}
