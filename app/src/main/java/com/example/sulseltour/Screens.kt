package com.example.sulseltour

sealed class Screens (val screen: String) {
    data object Home: Screens("home")
    data object Explore: Screens("explore")
    data object DaftarFavorit: Screens("daftarFavorit")
    data object Profile: Screens("profile")
}