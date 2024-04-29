package com.example.habittracker.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.habittracker.R
import com.example.habittracker.data.entities.Habit
import com.example.habittracker.model.HabitViewModel

@Composable
fun HomeScreen(habitViewModel: HabitViewModel) {
    val habits = habitViewModel.habitList.collectAsState(initial = emptyList()).value
    val setShowDialog = remember { mutableStateOf(false) }
    var deletingHabitId by remember { mutableStateOf<Int?>(null) }

    if (setShowDialog.value) {
        ConfirmDeletionDialog(setShowDialog = { setShowDialog.value = it }) {
            deletingHabitId?.let { habitViewModel.deleteHabit(it) }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp)
            .background(colorResource(id = R.color.white))
    ) {
        habits.forEach { habit ->
            HabitCard(
                habit = habit,
                onDeleteClick = {
                    deletingHabitId = habit.id
                    setShowDialog.value = true
                }
            )
        }
    }
}

@Composable
fun HabitCard(habit: Habit, onDeleteClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.black)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = habit.name, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Trash",
                    tint = Color.Red,
                    modifier = Modifier.clickable(onClick = onDeleteClick)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = habit.description, style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Alarm,
                    contentDescription = "Reminder",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = if (habit.reminder) "Reminder set" else "No reminder")
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewHabitCard() {
//    HabitCard(habit = Habit(name = "Drink Water", description = "Drink 8 glasses of water daily", interval = "Daily", reminder = true))
//}