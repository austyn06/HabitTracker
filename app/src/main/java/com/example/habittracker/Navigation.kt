package com.example.habittracker

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.habittracker.content.HomeScreen
import com.example.habittracker.content.ProfileScreen
import com.example.habittracker.content.StatsScreen
import com.example.habittracker.model.HabitViewModel

@Composable
fun Navigation(navController: NavHostController, habitViewModel: HabitViewModel, context: Context) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(habitViewModel = habitViewModel, context = context)
        }
        composable(route = Screen.Stats.route) {
            StatsScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen()
        }
    }
}