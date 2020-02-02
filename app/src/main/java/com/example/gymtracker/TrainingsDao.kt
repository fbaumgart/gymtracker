package com.example.gymtracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TrainingsDao {

    @Query("Select *  from trainings")
    fun getAllTrainings(): List<TrainingsEntity>


    @Query("Select MAX(TRAINING_ID) AS MAX_ID from trainings")
    fun getMaxTrainingID(): Int

    @Insert
    fun insertTraining(training: TrainingsEntity)

}