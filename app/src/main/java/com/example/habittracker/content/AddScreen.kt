package com.example.habittracker.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.habittracker.R
import com.example.habittracker.data.entities.Habit
import com.example.habittracker.model.HabitViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(habitViewModel: HabitViewModel, setShowDialog: (Boolean) -> Unit) {
    var habitName by remember { mutableStateOf(TextFieldValue()) }
    var habitDescription by remember { mutableStateOf(TextFieldValue()) }
    var interval by remember { mutableStateOf("") }
    var reminder by remember { mutableStateOf(false) }
    var dropdownExpanded by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = colorResource(id = R.color.white)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Add New Habit",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = colorResource(id = R.color.black)
                        )

                        Icon(
                            imageVector = Icons.Outlined.Cancel,
                            contentDescription = "Cancel",
                            tint = colorResource(id = R.color.black),
                            modifier = Modifier
                                .size(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
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
                            focusedIndicatorColor = colorResource(id = R.color.darker_background),
                            focusedLabelColor = colorResource(id = R.color.darker_background),
                            focusedTextColor = colorResource(id = R.color.black),
                            focusedContainerColor = colorResource(id = R.color.white),
                            unfocusedContainerColor = colorResource(id = R.color.white),
                            unfocusedTextColor = colorResource(id = R.color.black),
                            unfocusedIndicatorColor = colorResource(id = R.color.black),
                            unfocusedLabelColor = colorResource(id = R.color.black)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
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
                            focusedIndicatorColor = colorResource(id = R.color.darker_background),
                            focusedLabelColor = colorResource(id = R.color.darker_background),
                            focusedTextColor = colorResource(id = R.color.black),
                            focusedContainerColor = colorResource(id = R.color.white),
                            unfocusedContainerColor = colorResource(id = R.color.white),
                            unfocusedTextColor = colorResource(id = R.color.black),
                            unfocusedIndicatorColor = colorResource(id = R.color.black),
                            unfocusedLabelColor = colorResource(id = R.color.black)
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box {
                        OutlinedTextField(
                            modifier = Modifier
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
                                focusedIndicatorColor = colorResource(id = R.color.darker_background),
                                focusedLabelColor = colorResource(id = R.color.darker_background),
                                focusedTextColor = colorResource(id = R.color.black),
                                focusedContainerColor = colorResource(id = R.color.white),
                                unfocusedContainerColor = colorResource(id = R.color.white),
                                unfocusedTextColor = colorResource(id = R.color.black),
                                unfocusedIndicatorColor = colorResource(id = R.color.black),
                                unfocusedLabelColor = colorResource(id = R.color.black)
                            ),
                            readOnly = true
                        )

                        DropdownMenu(
                            expanded = dropdownExpanded,
                            onDismissRequest = { dropdownExpanded = false },
                            modifier = Modifier
                                .background(color = Color.LightGray)
                        ) {
                            val menuList = listOf(
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
                                            fontWeight = FontWeight.Medium,
                                            color = colorResource(id = R.color.black)
                                        )
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Reminder")

                        Spacer(modifier = Modifier.weight(1f))

                        Switch(
                            checked = reminder,
                            onCheckedChange = { reminder = it },
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

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            val habit = Habit(
                                name = habitName.text,
                                description = habitDescription.text,
                                interval = interval,
                                reminder = reminder
                            )

                            habitViewModel.insertHabit(habit)
                            setShowDialog(false)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = colorResource(id = R.color.white),
                            containerColor = colorResource(id = R.color.darker_background)
                        )
                    ) {
                        Text(
                            text = "Save",
                            modifier = Modifier.padding(start = 8.dp),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun AddScreenPreview() {
//    HabitTrackerTheme {
//        AddScreen()
//    }
//}