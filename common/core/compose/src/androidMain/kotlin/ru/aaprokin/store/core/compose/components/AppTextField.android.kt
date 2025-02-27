package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * @Preview
 */


/**
 * TODO описание
 */
@Composable
actual fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    enabled: Boolean,
    error: String?,
    hint: String?,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    behavior: TextFieldBehavior
) {
}