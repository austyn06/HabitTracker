package com.example.habittracker.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class Habit(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "interval")
    val interval: String,

    @ColumnInfo(name = "reminder")
    val reminder: Boolean = false,

//     @ColumnInfo(name = "completed")
//     val completed: Boolean = false
)