package com.example.habittracker.content

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.ui.theme.HabitTrackerTheme

@Composable
fun AddScreen() {
    var habitName by remember { mutableStateOf(TextFieldValue()) }
    var habitDescription by remember { mutableStateOf(TextFieldValue()) }
    var interval by remember { mutableStateOf("") }
    var reminderOn by remember { mutableStateOf(false) }
    var dropdownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
//            .background(colorResource(id = R.color.backgroundColor))
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add New Habit",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
//            color = colorResource(id = R.color.textColorPrimary),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = habitDescription,
            onValueChange = { habitDescription = it },
            label = { Text("Description") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { dropdownExpanded = true },
                value = interval.ifEmpty { "Select Interval" },
                onValueChange = { },
                label = { Text("Interval") },
                trailingIcon = {
                    Icon(
                        imageVector = if (dropdownExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                        contentDescription = if (dropdownExpanded) "Close dropdown" else "Open dropdown",
                        modifier = Modifier.clickable { dropdownExpanded = !dropdownExpanded }
                    )
                },
                readOnly = true,
                singleLine = true
            )

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                DropdownMenuItem(
                    onClick = {
                        interval = "Daily"
                        dropdownExpanded = false
                    },
                    text = { Text("Daily") }
                )
                DropdownMenuItem(
                    onClick = {
                        interval = "Weekly"
                        dropdownExpanded = false
                    },
                    text = { Text("Weekly") }
                )
                DropdownMenuItem(
                    onClick = {
                        interval = "Monthly"
                        dropdownExpanded = false
                    },
                    text = { Text("Monthly") }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Reminder")

            Spacer(modifier = Modifier.weight(1f))

            Switch(
                checked = reminderOn,
                onCheckedChange = { reminderOn = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle save action here
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Filled.Save, contentDescription = "Save")
            Text("Save", modifier = Modifier.padding(start = 8.dp))
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