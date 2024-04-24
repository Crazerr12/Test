package ru.aaprokin.store.feature.auth.presentation.signIn

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun SignInView(
    component: SignInComponent
) {
    val state by component.state.subscribeAsState()

    SignInViewContent(
        state = state,
        obtainViewAction = component::obtainViewAction
    )
}

@Composable
private fun SignInViewContent(
    state: SignInState,
    obtainViewAction: (SignInViewAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
//            .navigationBarsWithIme(),
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    obtainViewAction(SignInViewAction.PerformRegistration)
                },
            ) {
                Text("Регистрация")
            }
        }

    }
}

@Composable
private fun SignInViewContentBody(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .then(modifier),
    ) {
        // TODO()
    }
}
