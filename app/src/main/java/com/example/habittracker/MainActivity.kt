package com.example.habittracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.content.AddScreen
import com.example.habittracker.model.HabitViewModel
import com.example.habittracker.ui.theme.HabitTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val habitViewModel = HabitViewModel(application)

        setContent {
            HabitTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    MainScaffold(habitViewModel = habitViewModel)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(habitViewModel: HabitViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val setShowDialog = remember { mutableStateOf(false) }
    if (setShowDialog.value) {
        AddScreen(
            habitViewModel = habitViewModel,
            setShowDialog = { setShowDialog.value = it }
        )
    }

    Scaffold(
        topBar = {
            if (currentRoute == Screen.Home.route) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.actual_app_name), fontWeight = FontWeight.Bold)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        titleContentColor = colorResource(id = R.color.white),
                        containerColor = colorResource(id = R.color.darker_background)
                    )
                )
            }
        },
        content = { Navigation(navController = navController, habitViewModel = habitViewModel) },
        bottomBar = {
            BottomBar(navController = navController, currentRoute)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    setShowDialog.value = true
                },
                icon = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Add",
                        modifier = Modifier.size(16.dp)
                    )
                },
                text = { Text(text = "Add Habit", fontSize = 12.sp) },
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
                shape = CircleShape,
                contentColor = colorResource(id = R.color.white),
                containerColor = colorResource(id = R.color.darker_background)
            )
        }
    )
}

@Composable
fun BottomBar(navController: NavController, currentRoute: String?) {
    val screens = listOf(
        Screen.Home,
        Screen.Stats,
        Screen.Profile
    )

    NavigationBar(containerColor = colorResource(id = R.color.darker_background)) {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) },
                label = {
                    Text(text = screen.title, fontSize = 11.sp)
                },
                icon = {
                    Icon(
                        imageVector = if (currentRoute == screen.route) screen.selectedIcon else screen.icon,
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = colorResource(id = R.color.white),
                    selectedIconColor = colorResource(id = R.color.darker_background),
                    unselectedTextColor = colorResource(id = R.color.white),
                    unselectedIconColor = colorResource(id = R.color.white),
                    indicatorColor = colorResource(id = R.color.white)
                )
            )
        }
    }
}

// Toast for reminders
//fun showReminderToast(context: Context, message: String) {
//    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//}