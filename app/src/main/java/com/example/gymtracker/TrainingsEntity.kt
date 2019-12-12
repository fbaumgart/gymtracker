package com.example.gymtracker

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class TrainingsEntity(
    @PrimaryKey val training_id : Int,
    @ColumnInfo (name = "TIMESTAMP") val training_timestamp : String?,
    @ColumnInfo (name = "EXERCISE_ID") val exercise_id : Int
)