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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Query("DELETE FROM habit WHERE id = :id")
    suspend fun deleteHabit(id: Int)

    @Query("UPDATE habit SET completed = :completed WHERE id = :id")
    suspend fun habitCompleted(id: Int, completed: Boolean)
}