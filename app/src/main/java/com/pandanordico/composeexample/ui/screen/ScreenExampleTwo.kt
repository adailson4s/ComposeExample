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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.pandanordico.composeexample.R
import com.pandanordico.composeexample.navigation.Routes.ScreenExampleOne.toScreenExampleOne
import com.pandanordico.composeexample.ui.theme.Dimen

@Composable
fun ScreenExampleTwo(
    dimens: Dimen,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimens.default),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.text_example_of_screen_example, 2))
        Spacer(modifier = Modifier.height(dimens.default))
        Button(
            onClick = { navController.toScreenExampleOne() }
        ) {
            Text(text = stringResource(id = R.string.go_to_screen, 1))
        }
    }
}