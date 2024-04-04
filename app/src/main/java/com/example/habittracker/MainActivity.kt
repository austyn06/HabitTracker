package com.example.habittracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HabitTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScaffold()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = stringResource(id = R.string.actual_app_name)) }) },
        content = { Navigation(navController = navController) },
        bottomBar = { BottomBar(navController = navController) }
    )
}

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val screens = listOf(
        Screen.Home,
        Screen.Stats,
        Screen.Profile,
        Screen.Settings,
    )

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == screen.route) screen.selectedIcon else screen.icon,
                        contentDescription = screen.title
                    )
                }
            )
        }


    }

//    Box(
//        modifier = Modifier
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        FloatingActionButton(
//            onClick = { navController.navigate(Screen.Add.route) },
//            content = { Icon(Icons.Default.Add, contentDescription = "Add") }
//        )
//    }
}