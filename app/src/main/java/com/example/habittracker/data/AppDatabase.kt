package com.example.habittracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.habittracker.data.dao.HabitDAO
import com.example.habittracker.data.entities.Habit

@Database(entities = [Habit::class], version = 1, exportSchema = false)
abstract class AppDatabase(): RoomDatabase() {
    abstract fun habitDao(): HabitDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "habits"
                )
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}