package com.example.habittracker.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.habittracker.R
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
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
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
            color = colorResource(id = R.color.darker_background),
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Text(
                text = "Email:",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = "johndoe@example.com"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "About Me",
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "This is a short bio or description about the user. Here you can add more details about hobbies, interests, or any other information."
        )

        Spacer(modifier = Modifier.height(8.dp))

        ThemeSettingItem()

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Notifications", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Turn on Notifications",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Switch(
                checked = false,
                onCheckedChange = {},
                colors = SwitchDefaults.colors(
                    checkedBorderColor = Color.LightGray,
                    checkedThumbColor = colorResource(id = R.color.white),
                    checkedTrackColor = colorResource(id = R.color.darker_background),
                    uncheckedBorderColor = colorResource(id = R.color.black),
                    uncheckedThumbColor = colorResource(id = R.color.black),
                    uncheckedTrackColor = colorResource(id = R.color.white)
                )
            )
        }
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

        Switch(
            checked = false,
            onCheckedChange = {},
            colors = SwitchDefaults.colors(
                checkedBorderColor = Color.LightGray,
                checkedThumbColor = colorResource(id = R.color.white),
                checkedTrackColor = colorResource(id = R.color.darker_background),
                uncheckedBorderColor = colorResource(id = R.color.black),
                uncheckedThumbColor = colorResource(id = R.color.black),
                uncheckedTrackColor = colorResource(id = R.color.white)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    HabitTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileScreen()
        }
    }
}