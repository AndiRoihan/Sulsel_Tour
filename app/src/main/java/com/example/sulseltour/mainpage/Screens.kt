package com.example.sulseltour.mainpage

sealed class Screens(val screen: String) {
    object Home : Screens("home")
    object Explore : Screens("explore")
    object DaftarFavorit : Screens("daftarFavorit")
    object Profile : Screens("profile")
}
