package com.se7en.myindianexpress.navigation

sealed class Screen(val route: String) {

    object Home: Screen(route = "home_screen")
    object OnBoarding: Screen(route = "onboarding_screen")

}