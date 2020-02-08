package com.example.gymtracker


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [TrainingsEntity::class], version = 1)
    abstract class AppDatabase : RoomDatabase() {
    abstract fun trainingsDao(): TrainingsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(ctx: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    ctx.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase.db"
                )
                    .allowMainThreadQueries() // Does not scale very well!
                    .build()
            }
            return INSTANCE as AppDatabase
        }
    }

}