package com.example.gymtracker

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TrainingsDao {

    @Query("Select *  from TrainingsEntity ORDER BY timestamp DESC")
    fun getAllTrainings(): List<TrainingsEntity>

}