package com.example.mathgame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mathgame.HomeScreen
import com.example.mathgame.SplashScreen
import com.example.mathgame.ui.theme.GameScreen


@Composable
fun NavGraph (navController: NavHostController){
    NavHost(navController = navController, startDestination = Screens.Splash.route){
        composable(route = Screens.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Game.route + "/{level}",
            arguments = listOf(
                navArgument("level"){
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            GameScreen(navController, entry.arguments?.getString("level")!!)
        }
    }
}
