package com.example.habittracker.content

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.habittracker.R

@Composable
fun ConfirmDeletionDialog(setShowDialog: (Boolean) -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = { setShowDialog(false) },
        title = { Text(text = "Confirm Deletion") },
        text = { Text(text = "Are you sure you want to delete this habit?") },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm()
                    setShowDialog(false)
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Red)
            ) {
                Text("Delete")
            }
        },
        dismissButton = {
            Button(
                onClick = { setShowDialog(false) },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Gray)
            ) {
                Text("Cancel")
            }
        },
        containerColor = colorResource(id = R.color.white),
        textContentColor = Color.Black
    )
}