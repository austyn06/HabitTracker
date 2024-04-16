package com.example.habittracker.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.habittracker.R
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.backgroundColor))
            .padding(16.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "John Doe",
                fontWeight = FontWeight.Bold,
//                color = colorResource(id = R.color.textColorPrimary),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

//        Row(
//            modifier = Modifier.fillMaxWidth()
//        ) {
//
//
//            IconButton(
//                onClick = { navController.navigate(Screen.Settings.route) },
//                content = {
//                    Icon(
//                        Icons.Outlined.Settings,
//                        contentDescription = "Settings",
//                        tint = colorResource(id = R.color.textColorPrimary)
//                    )
//                }
//            )
//        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
//            color = colorResource(id = R.color.colorAccent),
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = "Email:",
                fontWeight = FontWeight.Bold,
//                color = colorResource(id = R.color.textColorPrimary),
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = "johndoe@example.com",
//                color = colorResource(id = R.color.textColorPrimary)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "About Me",
            fontWeight = FontWeight.Bold,
//            color = colorResource(id = R.color.textColorPrimary)
        )

        Text(
            text = "This is a short bio or description about the user. Here you can add more details about hobbies, interests, or any other information.",
//            color = colorResource(id = R.color.textColorSecondary)
        )

        Spacer(modifier = Modifier.height(8.dp))

        ThemeSettingItem()
    }
}

@Composable
fun ThemeSettingItem() {
    val isDarkModeEnabled: Boolean = false

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Dark Mode", style = MaterialTheme.typography.titleMedium)
            Text(
                text = if (!isDarkModeEnabled)
                    "Enable dark theme" else "Disable dark theme",
                style = MaterialTheme.typography.bodySmall
            )
        }

        Switch(checked = false, onCheckedChange = {} )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()

    HabitTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileScreen(navController)
        }
    }
}