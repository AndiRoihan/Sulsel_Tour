package com.example.sulseltour.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sulseltour.ui.screen.mainpage.DaftarFavorit
import com.example.sulseltour.ui.screen.mainpage.Explore
import com.example.sulseltour.ui.screen.mainpage.Home
import com.example.sulseltour.ui.screen.mainpage.Profile

@Composable
fun MainScreenNavHost(
    navController: NavHostController,
    startDestination: String = MainScreenRoutes.Home.route,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(MainScreenRoutes.Home.route) { Home() }
        composable(MainScreenRoutes.Explore.route) { Explore() }
        composable(MainScreenRoutes.DaftarFavorit.route) { DaftarFavorit() }
        composable(MainScreenRoutes.Profile.route) { Profile() }
    }
}