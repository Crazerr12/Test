package ru.aaprokin.store.core.mediator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ru.aaprokin.store.core.utils.toast.ToastState
import ru.aaprokin.store.feature.auth.presentation.AuthCoordinator

@Composable
fun RootCoordinator(
    rootComponent: RootComponent,
    modifier: Modifier = Modifier
) {
    val toastState by rootComponent.toast.subscribeAsState()

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {

        }
        RootCoordinatorContent(
            rootComponent = rootComponent,
            toastState = toastState
        )
    }
}

@Composable
private fun RootCoordinatorContent(
    rootComponent: RootComponent,
    toastState: ToastState
) {
    Box {
        Children(
            stack = rootComponent.stack,
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.AuthChild ->
                    AuthCoordinator(component = child.component)
            }
        }
//        RootSnackbar(
//            toastState = toastState
//        )
    }
}
//
//@Composable
//fun BoxScope.RootSnackbar(
//    toastState: ToastState
//) {
//    val contentPadding: PaddingValues = WindowInsets(
//        left = AppTheme.Dimens.offsetMedium,
//        top = 0.dp,
//        right = AppTheme.Dimens.offsetMedium,
//        bottom = AppTheme.Dimens.offsetMedium
//    )
//        .add(navigationBarsWithIme())
//        .asPaddingValues()
//
//    AnimatedVisibility(
//        modifier = Modifier
//            .align(Alignment.BottomCenter),
//        visible = toastState.show,
//        enter = slideInVertically(
//            initialOffsetY = { it }
//        ),
//        exit = slideOutVertically(
//            targetOffsetY = { it }
//        )
//    ) {
//        val resources = LocalContext.current.resources
//        Box(
//            modifier = Modifier
//                .padding(contentPadding)
//        ) {
//            AppIconTextSnackbar(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                icon = when (toastState.payload.level) {
//                    ToastLevel.Success -> AppSnackbarIcons.Success
//                    ToastLevel.Danger -> AppSnackbarIcons.Danger
//                },
//                text = when (val message = toastState.payload.message) {
//                    is StringRes.Raw -> message.value ?: defaultUnknownError()
//                    is StringRes.Res -> resources.getString(message.value)
//                    else -> defaultUnknownError()
//                }
//            )
//        }
//    }
//}
