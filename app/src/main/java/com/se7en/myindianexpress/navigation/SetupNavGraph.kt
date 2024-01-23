package com.se7en.myindianexpress.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.se7en.myindianexpress.screens.home.HomeScreen
import com.se7en.myindianexpress.screens.onboarding.OnBoardingScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination

    ) {
        composable(route = Screen.OnBoarding.route) {
            OnBoardingScreen(navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}