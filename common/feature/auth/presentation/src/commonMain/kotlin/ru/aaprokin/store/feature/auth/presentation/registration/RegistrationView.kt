package ru.aaprokin.store.feature.auth.presentation.registration

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
fun RegistrationView(
    component: RegistrationComponent
) {
    val state by component.state.subscribeAsState()

    RegistrationViewContent(
        state = state,
        obtainViewAction = component::obtainViewAction
    )
}

@Composable
private fun RegistrationViewContent(
    state: RegistrationState,
    obtainViewAction: (RegistrationViewAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
//            .navigationBarsWithIme()
        ,
        topBar = {
//            EkfToolbar(
//                onNavigationClick = {
//                    obtainViewAction(RegistrationViewAction.BackClicked)
//                },
//                title = "Title",
//            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    obtainViewAction(RegistrationViewAction.BackClicked)
                },
            ) {
                Text("Назад")
            }
        }
//        DataStateFoldView(
//            dataState = DataState.Loading<String>(), // TODO change state
//            error = { title, description ->
//                EkfScreenError(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .navigationBarsWithIme(),
//                    title = title,
//                    description = description,
//                    onRetryClick = {
//                        TODO()
//                    }
//                )
//            },
//            loading = {
//                EkfScreenLoading(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .navigationBarsWithIme()
//                )
//            },
//            ok = {
//                RegistrationViewContentBody(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .navigationBarsWithIme(),
//                )
//            }
//        )
    }
}

@Composable
private fun RegistrationViewContentBody(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .then(modifier),
    ) {
        // TODO()
    }
}

//@Preview
@Composable
private fun RegistrationViewContentPreview() {
    RegistrationViewContent(
        state = InitialRegistrationState,
        obtainViewAction = { }
    )
}