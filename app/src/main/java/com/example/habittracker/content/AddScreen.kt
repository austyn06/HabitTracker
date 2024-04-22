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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R
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
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Add New Habit",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = habitName,
            onValueChange = { habitName = it },
            textStyle = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            label = {
                Text(
                    text = "Habit Name",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(id = R.color.teal),
                focusedLabelColor = colorResource(id = R.color.teal),
                focusedTextColor = colorResource(id = R.color.black),
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedContainerColor = colorResource(id = R.color.white),
                unfocusedTextColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = habitDescription,
            onValueChange = { habitDescription = it },
            textStyle = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            label = {
                Text(
                    text = "Habit Description",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(id = R.color.teal),
                focusedLabelColor = colorResource(id = R.color.teal),
                focusedTextColor = colorResource(id = R.color.black),
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedContainerColor = colorResource(id = R.color.white),
                unfocusedTextColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { dropdownExpanded = true },
                value = interval.ifEmpty { "Selected Interval" },
                onValueChange = { },
                textStyle = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
                label = {
                    Text(
                        text = "Interval",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = if (dropdownExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                        contentDescription = if (dropdownExpanded) "Close dropdown" else "Open dropdown",
                        modifier = Modifier.clickable { dropdownExpanded = !dropdownExpanded }
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(id = R.color.teal),
                    focusedLabelColor = colorResource(id = R.color.teal),
                    focusedTextColor = colorResource(id = R.color.black),
                    focusedContainerColor = colorResource(id = R.color.white),
                    unfocusedContainerColor = colorResource(id = R.color.white),
                    unfocusedTextColor = colorResource(id = R.color.black)
                ),
                readOnly = true
            )

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false },
                modifier = Modifier.fillMaxWidth()
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
                            interval = value
                            dropdownExpanded = false
                        },
                        text = {
                            Text(
                                text = value,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            )
                        },
                        colors = MenuDefaults.itemColors(
                            textColor = colorResource(id = R.color.black)
                        )
                    )
                }
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
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(id = R.color.black),
                containerColor = colorResource(id = R.color.teal)
            )
        ) {
            Icon(Icons.Filled.Save, contentDescription = "Save")
            Text(
                text = "Save",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
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