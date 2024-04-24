package ru.aaprokin.store.core.compose.components

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ButtonPreview() {
    Surface {

    AppButton(label = "123", onClick = { })
    }
}
