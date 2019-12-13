package com.example.gymtracker

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity
data class ExercisesEntity (
    @PrimaryKey (autoGenerate = true) val exercise_id: Int,
    @ColumnInfo (name = "EXERCISE_NAME") val exercise_description: String?
    )