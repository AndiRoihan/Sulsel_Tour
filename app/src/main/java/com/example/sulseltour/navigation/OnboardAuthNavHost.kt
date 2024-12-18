package com.example.sulseltour.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sulseltour.ui.screen.auth.LoginScreen
import com.example.sulseltour.ui.screen.auth.RegisterScreen
import com.example.sulseltour.ui.component.NavigationBar
import com.example.sulseltour.ui.screen.onboard.OnboardingScreen

//@Serializable object Onboarding
//
//@Serializable object Authentication
//@Serializable object Login
//@Serializable object Register
//
//@Serializable object MainScreen
//@Serializable object Home
//@Serializable object Explore
//@Serializable object DaftarFavorit
//@Serializable object Profile
//
//@Composable
//fun Navigation(navController: NavHostController = rememberNavController()) {
//    NavHost(
//        navController = navController,
//        startDestination = Onboarding
//    ) {
//        composable<Onboarding> {
//            OnboardingScreen(onLastNextClicked = { navController.navigate(route = Authentication) })
//        }
//        navigation<Authentication>(
//            startDestination = Login
//        ) {
//            composable<Login> {
//                LoginPage(onSubmitClicked = { navController.navigate(route = Register) })
//            }
//            composable<Register> {
//                RegisterPage(navController = navController)
//            }
//        }
//        composable<MainScreen> {
//            NavigationBar()
//        }
//    }
//}

//@Composable
//fun RootNavHost(navController: NavHostController) {
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
fun OnboardAuthNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Onboarding"
    ) {
        composable("Onboarding") {
            OnboardingScreen(navController = navController)
        }
        navigation(
            startDestination = "Login",
            route = "Auth"
        ) {
            composable("Login") {
                LoginScreen(navController = navController)
            }
            composable("Register") {
                RegisterScreen(navController = navController)
            }
        }
        composable("MainScreen") {
            NavigationBar()
        }
    }
}