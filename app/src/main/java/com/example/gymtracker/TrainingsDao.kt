package com.example.gymtracker

import androidx.room.Dao
import androidx.room.Query


@Dao
interface TrainingsDao {

    @Query("Select *  from trainings ORDER BY timestamp DESC")
    fun getAllTrainings(): List<TrainingsEntity>

}