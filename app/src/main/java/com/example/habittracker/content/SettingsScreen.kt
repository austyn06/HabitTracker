package com.example.habittracker.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.R
import com.example.habittracker.ui.theme.HabitTrackerTheme
import com.example.habittracker.ui.theme.ThemePreferences

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "Back", tint = Color.White)
                }
            },
            title = { Text(text = "Back") },
            colors = TopAppBarDefaults.topAppBarColors(
                titleContentColor = Color.White,
                containerColor = colorResource(id = R.color.purple_700)
            )
        )

        ThemeSettingItem()
    }
}

@Composable
fun ThemeSettingItem() {
    val context = LocalContext.current
    val isDarkThemeEnabled = remember { mutableStateOf(ThemePreferences.isDarkThemeEnabled(context)) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Dark Mode", style = MaterialTheme.typography.titleMedium)
            Text(text = "Enable dark theme", style = MaterialTheme.typography.bodySmall)
        }
        Switch(checked = isDarkThemeEnabled.value, onCheckedChange = {
            isDarkThemeEnabled.value = it
            ThemePreferences.setDarkThemeEnabled(context, it)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    HabitTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            SettingsScreen(navController)
        }
    }
}