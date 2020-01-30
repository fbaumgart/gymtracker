package com.example.gymtracker

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(TrainingsEntity::class), version = 1)
    abstract class AppDatabase : RoomDatabase() {
    abstract fun trainingsDao(): TrainingsDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(ctx: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    ctx.getApplicationContext(),
                    AppDatabase::class.java,
                    "AppDatabase"
                )
                    .allowMainThreadQueries() // Does not scale very well!
                    .build()
            }

            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}