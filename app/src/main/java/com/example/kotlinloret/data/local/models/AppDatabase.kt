package com.example.kotlinloret.data.local.models

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinloret.data.local.models.UserLocal

class AppDatabase {
    @Database(entities = arrayOf(
        UserLocal::class
    ), version = 1)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun databaseDao(): DatabaseDao
    }
}