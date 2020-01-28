package com.example.gymtracker

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import android.support.annotation.NonNull
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "exercises")
data class ExercisesEntity(
    @PrimaryKey (autoGenerate = true) @ColumnInfo(name = "ID") val exercise_id: Int = 1,
    @ColumnInfo (name = "EXERCISE_NAME") val exercise_description: String
    ): Parcelable