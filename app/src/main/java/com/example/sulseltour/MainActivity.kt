package com.example.sulseltour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.sulseltour.navigation.OnboardAuthNavHost
//import com.example.sulseltour.navigation.RootNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MainApp()
//            VerticalAndHorizontalScroll()
        }
    }
}

//@Composable
//fun NavigationComponent(navController: NavHostController) {
//    NavHost(
//        navController = navController,
//        startDestination = "Onboarding"
//    ) {
//        composable("Onboarding") {
//            OnboardingScreen(navController = navController)
//        }
//        composable("RegisterScreen") {
//            RegisterPage(navController = navController)
//        }
//        composable("LoginScreen") {
//            LoginPage(navController = navController)
//        }
//        composable("NavigationBar") {
//            NavigationBar()
//        }
//    }
//}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    OnboardAuthNavHost(navController = navController)
//    NavigationComponent(navController = navController)
}
