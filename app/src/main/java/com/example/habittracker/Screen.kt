package com.example.habittracker

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.InsertChart
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.InsertChartOutlined
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(var route: String, var icon: ImageVector, var selectedIcon: ImageVector, var title: String = "") {
    object Home : Screen(
        "home", Icons.Outlined.Home,
        Icons.Filled.Home, "Home"
    )

    object Stats : Screen(
        "stats", Icons.Outlined.InsertChartOutlined,
        Icons.Filled.InsertChart, "Stats"
    )

    object Profile : Screen(
        "profile", Icons.Outlined.Person,
        Icons.Filled.Person, "Profile"
    )
}