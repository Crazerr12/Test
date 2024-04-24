package ru.aaprokin.store.core.compose.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import store.common.core.compose.generated.resources.Res
import store.common.core.compose.generated.resources.ic_eye_open

/**
 * TODO описание
 */
@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppTextFieldPassword(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    error: String? = "",
    hint: String? = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    behavior: TextFieldBehavior = TextFieldBehavior.Default,
) {
    // TODO
    painterResource(Res.drawable.ic_eye_open)
}
