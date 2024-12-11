package com.example.sulseltour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sulseltour.ui.theme.SulselTourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SulselTourTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavigationBar()
                }
            }
        }
    }
}

@Composable
fun NavigationBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray)
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Search
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray)
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Favorite
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Favorite) Color.White else Color.DarkGray)
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray)
                }
            }
        }
    ) {
        paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screen,
        modifier = Modifier.padding(paddingValues)) {
            composable(Screens.Home.screen){ Home() }
            composable(Screens.Explore.screen){ Explore() }
            composable(Screens.DaftarFavorit.screen){ DaftarFavorit() }
            composable(Screens.Profile.screen){ Profile() }
    }
    }
}

@Preview
@Composable
fun NavigationBarPreview() {
    SulselTourTheme {
        NavigationBar()
    }
}