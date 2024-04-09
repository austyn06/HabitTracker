package com.example.habittracker

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habittracker.content.AddScreen
import com.example.habittracker.content.CommunityScreen
import com.example.habittracker.content.HomeScreen
import com.example.habittracker.content.ProfileScreen
import com.example.habittracker.content.SettingsScreen
import com.example.habittracker.content.StatsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
        composable(route = Screen.Stats.route) {
            StatsScreen()
        }
        composable(route = Screen.Add.route) {
            AddScreen()
        }
        composable(route = Screen.Community.route) {
            CommunityScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}