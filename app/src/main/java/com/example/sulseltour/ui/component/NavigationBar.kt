package com.example.sulseltour.ui.component

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
import androidx.navigation.compose.rememberNavController
import com.example.sulseltour.navigation.MainScreenNavHost
import com.example.sulseltour.navigation.MainScreenRoutes

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
                        navigationController.navigate(MainScreenRoutes.Home.route) {
                            popUpTo(MainScreenRoutes.Home.route) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = "Home",
                            tint = if (selected.value == "Home") Color.Black else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Search"
                        navigationController.navigate(MainScreenRoutes.Explore.route) {
                            popUpTo(MainScreenRoutes.Explore.route) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = if (selected.value == "Search") Color.Black else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Favorite"
                        navigationController.navigate(MainScreenRoutes.DaftarFavorit.route) {
                            popUpTo(MainScreenRoutes.DaftarFavorit.route) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            tint = if (selected.value == "Favorite") Color.Black else Color.DarkGray
                        )
                    }

                    IconButton(onClick = {
                        selected.value = "Profile"
                        navigationController.navigate(MainScreenRoutes.Profile.route) {
                            popUpTo(MainScreenRoutes.Profile.route) { inclusive = true }
                        }
                    }, modifier = Modifier.weight(1f)) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = if (selected.value == "Profile") Color.Black else Color.DarkGray
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        MainScreenNavHost(
            navController = navigationController,
            startDestination = MainScreenRoutes.Home.route,
            modifier = Modifier.padding(paddingValues)
        )
    }
}
