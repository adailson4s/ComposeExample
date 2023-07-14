package com.pandanordico.composeexample.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavController

sealed class Routes(
    val route: String,
    val arguments: List<NamedNavArgument> = listOf()
) {

    object ExampleOneScreen : Routes(route = "example_one_screen") {
        fun NavController.toExampleOneScreen() =
            navigate(route) {
                popBackStack(route, true)
            }
    }

    object ExampleTwoScreen : Routes(route = "example_two_screen") {
        fun NavController.toExampleTwoScreen() = navigate(route)
    }
}