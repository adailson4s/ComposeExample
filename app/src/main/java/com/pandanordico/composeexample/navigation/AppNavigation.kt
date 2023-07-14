package com.pandanordico.composeexample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pandanordico.composeexample.ui.screen.*
import com.pandanordico.composeexample.ui.theme.Dimen

@Composable
fun AppNavigation(navHostController: NavHostController) {
    val dimens = Dimen()

    NavHost(navController = navHostController, startDestination = Routes.ExampleOneScreen.route) {

        composable(route = Routes.ExampleOneScreen.route) {
            ExampleOneScreen(
                dimens = dimens,
                navController = navHostController
            )
        }

        composable(route = Routes.ExampleTwoScreen.route) {
            ExampleTwoScreen(
                dimens = dimens,
                navController = navHostController
            )
        }
    }
}