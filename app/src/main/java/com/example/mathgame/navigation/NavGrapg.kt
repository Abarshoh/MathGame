package com.example.mathgame.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mathgame.GameScreen
import com.example.mathgame.HomeScreen
import com.example.mathgame.ResultScreen
import com.example.mathgame.SplashScreen
import com.example.mathgame.model.Record


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
            GameScreen(navController, entry.arguments?.getInt("level")!!)
        }
        composable(route = Screens.Result.route,
            arguments = listOf(
                navArgument("correct"){
                    type = NavType.IntType
                },navArgument("incorrect"){
                    type = NavType.IntType
                },navArgument("level"){
                    type = NavType.IntType
                },navArgument("new_record"){
                    type = NavType.BoolType
                },
            )
        ) { entry ->
            val correct = entry.arguments?.getInt("correct")!!
            val incorrect = entry.arguments?.getInt("incorrect")!!
            val level = entry.arguments?.getInt("level")!!
            val newRecord = entry.arguments?.getBoolean("new_record")!!
            ResultScreen(
                navController = navController, result = Record(
                correct = correct,
                incorrect = incorrect,
                level = level,
                newRecord = newRecord
            )
            )
        }
    }
}
