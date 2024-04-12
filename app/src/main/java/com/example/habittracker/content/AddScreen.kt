package com.example.habittracker.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun AddScreen() {
    var habitName by remember { mutableStateOf(TextFieldValue()) }
    var habitDescription by remember { mutableStateOf(TextFieldValue()) }
    var frequency by remember { mutableStateOf("") }
    var reminderOn by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
            .padding(16.dp),
    ) {
        Text(
            text = "Add New Habit",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = colorResource(id = R.color.textColorPrimary),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Habit Name Input
        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Habit Description Input
        OutlinedTextField(
            value = habitDescription,
            onValueChange = { habitDescription = it },
            label = { Text("Description") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Frequency Selector
        DropdownMenu(
            expanded = false,
            onDismissRequest = {},
            content = {
                DropdownMenuItem(
                    onClick = { frequency = "Daily" },
                    text = { Text("Daily") }
                )
                DropdownMenuItem(
                    onClick = { frequency = "Weekly" },
                    text = { Text("Weekly") }
                )
                DropdownMenuItem(
                    onClick = { frequency = "Monthly" },
                    text = { Text("Monthly") }
                )
            }
        )

        // Reminder Toggle
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Reminder")
            Switch(
                checked = reminderOn,
                onCheckedChange = { reminderOn = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Save Button
        Button(
            onClick = {
                // Handle save action here
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.Save, contentDescription = "Save")
            Text("Save")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    HabitTrackerTheme {
        AddScreen()
    }
}