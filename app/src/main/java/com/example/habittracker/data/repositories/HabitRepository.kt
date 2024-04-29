package com.example.habittracker.data.repositories

import android.app.Application
import com.example.habittracker.data.AppDatabase
import com.example.habittracker.data.dao.HabitDAO
import com.example.habittracker.data.entities.Habit
import kotlinx.coroutines.flow.Flow

class HabitRepository(application: Application) {
    private var habitDao: HabitDAO

    init {
        val db = AppDatabase.getDatabase(application)
        habitDao = db.habitDao()
    }

    fun readAllHabits(): Flow<List<Habit>> = habitDao.fetchAllHabits()

    suspend fun insertHabit(habit: Habit) {
        habitDao.insertHabit(habit)
    }

    suspend fun deleteHabit(id: Int) {
        habitDao.deleteHabit(id)
    }
}