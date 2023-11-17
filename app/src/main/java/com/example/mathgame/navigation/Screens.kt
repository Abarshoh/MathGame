package com.example.mathgame.navigation

sealed class Screens(val route: String) {
    object Splash:Screens("splash_screen")
    object Home : Screens("home_screen")
    object Game : Screens("game_screen")



    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}
