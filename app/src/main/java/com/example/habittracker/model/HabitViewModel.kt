package com.example.habittracker.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.data.entities.Habit
import com.example.habittracker.data.repositories.HabitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HabitViewModel(application: Application) : AndroidViewModel(application) {
    private val habitRepository: HabitRepository = HabitRepository(application)

    private var _habitList = fetchAllHabits()
    val habitList: Flow<List<Habit>>
        get() = _habitList

    fun fetchAllHabits(): Flow<List<Habit>> = habitRepository.readAllHabits()

    fun insertHabit(habit: Habit) {
        viewModelScope.launch {
            habitRepository.insertHabit(habit)
        }
    }

    fun deleteHabit(id: Int) {
        viewModelScope.launch {
            habitRepository.deleteHabit(id)
        }
    }

    fun habitCompleted(id: Int, completed: Boolean) {
        viewModelScope.launch {
            habitRepository.habitCompleted(id, completed)
        }
    }
}