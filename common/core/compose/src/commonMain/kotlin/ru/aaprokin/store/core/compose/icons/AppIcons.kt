package ru.aaprokin.store.core.compose.icons

import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import store.common.core.compose.generated.resources.Res
import store.common.core.compose.generated.resources.ic_eye_close
import store.common.core.compose.generated.resources.ic_eye_open

@OptIn(ExperimentalResourceApi::class)
object AppIcons {

    val EyeClose
        @Composable
        get() = painterResource(resource = Res.drawable.ic_eye_close)
    val EyeOpen
        @Composable
        get() = painterResource(resource = Res.drawable.ic_eye_open)
}
