package com.example.gymtracker

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TrainingsDao {

    @Query("Select *  from trainings")
    fun getAllTrainings(): List<TrainingsEntity>

    @Query("Select MAX(TRAINING_ID) AS MAX_TRAINING_ID from trainings")
    fun getMaxTrainingID(): Int

    @Query("Select MAX(ID) AS MAX_ID from trainings")
    fun getMaxID(): Int

    @Query("Select ID, TRAINING_ID, EXERCISE_NAME, REPS, WEIGHT from trainings WHERE TRAINING_ID = :trainingID")
    fun getExercisesFromTraining(trainingID : Int) : List<ExercisesFromTraining>

    @Insert
    fun insertTraining(training: TrainingsEntity)

    @Query("Delete FROM trainings where ID = :id")
    fun deleteExerciseFromTraining(id : Int)

    @Query("Delete from trainings")
    fun deleteAllEntries()
}