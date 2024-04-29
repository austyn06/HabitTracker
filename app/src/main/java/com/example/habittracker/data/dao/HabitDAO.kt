package com.example.habittracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.habittracker.data.entities.Habit
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDAO {
    @Query("SELECT * FROM habit")
    fun fetchAllHabits(): Flow<List<Habit>>

    // Create a new habit
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)
}