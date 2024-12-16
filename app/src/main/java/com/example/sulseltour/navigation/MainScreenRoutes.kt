package com.example.sulseltour.navigation

sealed class MainScreenRoutes(val route: String) {
    object Home : MainScreenRoutes("home")
    object Explore : MainScreenRoutes("explore")
    object DaftarFavorit : MainScreenRoutes("daftarFavorit")
    object Profile : MainScreenRoutes("profile")
}
