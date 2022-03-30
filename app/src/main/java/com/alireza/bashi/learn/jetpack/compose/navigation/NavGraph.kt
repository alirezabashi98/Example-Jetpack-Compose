package com.alireza.bashi.learn.jetpack.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alireza.bashi.learn.jetpack.compose.ui.DetailScreen
import com.alireza.bashi.learn.jetpack.compose.ui.HomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route
        ){
            DetailScreen(navController = navController)
        }
    }
}