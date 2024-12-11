package com.example.sulseltour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sulseltour.onboard.OnboardingScreen
import com.example.sulseltour.ui.theme.SulselTourTheme
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Onboarding"
    ) {
        composable("Onboarding") {
            OnboardingScreen(navController = navController)
        }
        composable("RegisterScreen") {
            RegisterPage(navController = navController)
        }
        composable("LoginScreen") {
            LoginPage(navController = navController)
        }
        composable("NavigationBar") {
            NavigationBar()
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavigationComponent(navController = navController)
}
