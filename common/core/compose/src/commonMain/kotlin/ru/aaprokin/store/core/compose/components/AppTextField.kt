package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi

/**
 * TODO описание
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
expect fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    error: String? = "",
    hint: String? = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    behavior: TextFieldBehavior = TextFieldBehavior.Default,
)

sealed interface TextFieldBehavior {
    data object Default : TextFieldBehavior
    data class Button(val action: () -> Unit) : TextFieldBehavior
}
