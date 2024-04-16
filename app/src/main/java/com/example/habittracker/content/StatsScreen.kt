package com.example.habittracker.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatsScreen() {
    var selected by remember { mutableStateOf("Overall") }
    var dropdownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.backgroundColor))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            OutlinedTextField(
                modifier = Modifier
                    .width(130.dp)
                    .clickable { dropdownExpanded = true },
                value = selected,
                onValueChange = {},
                label = {},
                trailingIcon = {
                    Icon(
                        imageVector = if (dropdownExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                        contentDescription = if (dropdownExpanded) "Close dropdown" else "Open dropdown",
                        modifier = Modifier.clickable { dropdownExpanded = !dropdownExpanded }
                    )
                },
                readOnly = true
            )

            DropdownMenu(
                modifier = Modifier.width(130.dp),
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false }
            ) {
                val menuList = listOf(
                    "Overall",
                    "Daily",
                    "Weekly",
                    "Monthly"
                )

                menuList.forEach { value ->
                    DropdownMenuItem(
                        onClick = {
                            selected = value
                            dropdownExpanded = false
                        },
                        text = { Text(text = value) },
//                        colors = MenuDefaults.itemColors(
//                            textColor = colorResource(id = R.color.textColorPrimary),
//
//                        ),
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        DailyProgressCircle(progress = 0.75f, progressText = "75%")

        Spacer(modifier = Modifier.height(20.dp))

        StatisticsCard("Total Habits", "12")
        StatisticsCard("Longest Streak", "15 days")
    }
}

@Composable
fun DailyProgressCircle(progress: Float, progressText: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(200.dp)
    ) {
        CircularProgressIndicator(
            progress = progress,
            modifier = Modifier.matchParentSize(),
            strokeWidth = 8.dp,
            trackColor = Color.LightGray,
//            color = colorResource(id = R.color.colorAccent)
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = progressText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
//                color = colorResource(id = R.color.textColorPrimary)
            )
            Text(
                text = "Completed",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
//                color = colorResource(id = R.color.textColorPrimary)
            )
        }
    }
}

@Composable
fun StatisticsCard(statName: String, statValue: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = colorResource(id = R.color.colorAccent)
//        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = statName,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
//                color = colorResource(id = R.color.textColorPrimary)
            )
            Text(
                text = statValue,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
//                color = colorResource(id = R.color.colorPrimaryDark)
            )
        }
    }
}