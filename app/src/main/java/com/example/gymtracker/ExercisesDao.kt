package com.example.gymtracker

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ExercisesDao {

    @Query("Select *  from ExercisesEntity")
    fun getAllExercises(): List<ExercisesEntity>

    @Insert
    fun insertExercise(exercise : ExercisesEntity)

}