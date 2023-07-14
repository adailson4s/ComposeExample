package com.pandanordico.composeexample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pandanordico.composeexample.R
import com.pandanordico.composeexample.navigation.Routes.ExampleTwoScreen.toExampleTwoScreen
import com.pandanordico.composeexample.ui.viewmodel.ExampleOneViewModel
import com.pandanordico.composeexample.ui.theme.ComposeExampleTheme
import com.pandanordico.composeexample.ui.theme.Dimen

@Composable
fun ExampleOneScreen(
    dimens: Dimen,
    navController: NavController,
    viewModel: ExampleOneViewModel = hiltViewModel()
) {
    val exampleByViewModel by viewModel.example.collectAsState()
    val getRandomNumberControl by viewModel.getRandomNumberControl.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimens.default),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.text_example_of_screen_example, "1"))
        Spacer(modifier = Modifier.height(dimens.default))
        Button(
            onClick = { navController.toExampleTwoScreen() }
        ) {
            Text(text = stringResource(id = R.string.go_to_screen, "2"))
        }
        Spacer(modifier = Modifier.height(dimens.default))
        Text(text = exampleByViewModel)
        Spacer(modifier = Modifier.height(dimens.default))
        Button(
            onClick = { viewModel.startOrPauseRandomNumber(!getRandomNumberControl) }
        ) {
            Text(
                text = if (getRandomNumberControl)
                    stringResource(R.string.stop_random_number)
                else
                    stringResource(R.string.resume_random_number)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ExampleOneScreenPreview() {
    ComposeExampleTheme {
        ExampleOneScreen(
            dimens = Dimen(),
            navController = NavController(LocalContext.current)
        )
    }
}