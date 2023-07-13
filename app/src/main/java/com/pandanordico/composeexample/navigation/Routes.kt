package com.pandanordico.composeexample.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController

sealed class Routes(
    val route: String,
    val arguments: List<NamedNavArgument> = listOf()
) {

    object ScreenExampleOne : Routes(route = "screen_example_one") {
        fun NavController.toScreenExampleOne() =
            navigate(route) {
                popBackStack(route, true)
            }
    }

    object ScreenExampleTwo : Routes(route = "screen_example_two") {
        fun NavController.toScreenExampleTwo() = navigate(route)
    }
}