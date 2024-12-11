package com.example.sulseltour

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationBar() {
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf("Home") }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxSize()) {
                    IconButton(onClick = {
                        selected.value = "Home"
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(Screens.Home.screen) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                            tint = if (selected.value == "Home") Color.White else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Search"
                        navigationController.navigate(Screens.Explore.screen) {
                            popUpTo(Screens.Explore.screen) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = if (selected.value == "Search") Color.White else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Favorite"
                        navigationController.navigate(Screens.DaftarFavorit.screen) {
                            popUpTo(Screens.DaftarFavorit.screen) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            tint = if (selected.value == "Favorite") Color.White else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Profile"
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(Screens.Profile.screen) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = if (selected.value == "Profile") Color.White else Color.DarkGray
                        )
                    }
                }
            }
        }
    )
    { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { Home() }
            composable(Screens.Explore.screen) { Explore() }
            composable(Screens.DaftarFavorit.screen) { DaftarFavorit() }
            composable(Screens.Profile.screen) { Profile() }
        }
    }
}
