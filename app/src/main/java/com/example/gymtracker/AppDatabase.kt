package com.example.gymtracker

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors


@Database(entities = arrayOf(TrainingsEntity::class, ExercisesEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trainingsDao(): TrainingsDao
    abstract fun exercisesDao(): ExercisesDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val NUMBER_OF_THREADS = 5
        val databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )   .addCallback(DbCallback)
                    .build()

                //Insert Case
                /*val thread = Thread {
                    var exerciseEntity = ExercisesEntity(1, "Pull-ups")

                    instance.exercisesDao().insertExercise(exerciseEntity)

                    //fetch Records
                    instance.exercisesDao().getAllExercises().forEach()
                    {
                        Log.i("Fetch Records", "Id:  : ${it.exercise_id}")
                        Log.i("Fetch Records", "Name:  : ${it.exercise_description}")
                    }
                }
                thread.start()*/

                INSTANCE = instance
                return instance
            }
        }

        private val DbCallback = object : RoomDatabase.Callback(){
            override fun onOpen(db: android.arch.persistence.db.SupportSQLiteDatabase) {
                super.onOpen(db)
                databaseWriteExecutor.execute{
                    val dao = INSTANCE!!.exercisesDao()

                    val exerciseEntity = ExercisesEntity(1, "Squat with barbell")
                    val exerciseEntity2 = ExercisesEntity(2, "Bench press")
                    val exerciseEntity3 = ExercisesEntity(3, "Dead lift")


                    dao.insertExercise(exerciseEntity)
                    dao.insertExercise(exerciseEntity2)
                    dao.insertExercise(exerciseEntity3)
                    Log.i("Fetch Records", "Id:  : ${exerciseEntity.exercise_id}")
                    Log.i("Fetch Records", "Name:  : ${exerciseEntity.exercise_description}")
                }
            }
        }
    }
}