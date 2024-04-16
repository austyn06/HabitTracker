package com.example.habittracker.content

import androidx.compose.animation.defaultDecayAnimationSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habittracker.R

@Composable
fun StatsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.backgroundColor))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            color = colorResource(id = R.color.colorAccent)
        )
        Text(text = progressText, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun StatisticsCard(statName: String, statValue: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = statName, fontWeight = FontWeight.Medium, fontSize = 18.sp)
            Text(text = statValue, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = colorResource(id = R.color.colorPrimary))
        }
    }
}