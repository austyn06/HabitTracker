package com.example.habittracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    color = colorResource(id = R.color.white)
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
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
        content = { Navigation(navController = navController) },
        bottomBar = {
            BottomBar(navController = navController, currentRoute)
        }
    )
}

@Composable
fun BottomBar(navController: NavController, currentRoute: String?) {
    val screens = listOf(
        Screen.Home,
        Screen.Stats,
        Screen.Add,
        Screen.Team,
        Screen.Profile,
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBar(
            containerColor = colorResource(id = R.color.darker_background)
        ) {
            screens.forEach { screen ->
                if (screen != Screen.Add) {
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = { navController.navigate(screen.route) },
                        icon = {
                            Icon(
                                imageVector = if (currentRoute == screen.route) screen.selectedIcon else screen.icon,
                                contentDescription = screen.title,
                                modifier = Modifier.size(28.dp)
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = colorResource(id = R.color.darker_background),
                            unselectedIconColor = colorResource(id = R.color.white),
                            indicatorColor = colorResource(id = R.color.white)
                        )
                    )
                } else Spacer(modifier = Modifier.weight(1f))
            }
        }

        FloatingActionButton(
            onClick = { navController.navigate(Screen.Add.route) },
            content = {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(28.dp)
                )
            },
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 4.dp),
            shape = CircleShape,
            contentColor = colorResource(id = R.color.darker_background),
            containerColor = colorResource(id = R.color.white)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview() {
    HabitTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(id = R.color.white)
        ) {
            MainScaffold()
        }
    }
}