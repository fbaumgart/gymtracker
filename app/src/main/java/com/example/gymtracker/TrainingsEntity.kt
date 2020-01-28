package com.example.gymtracker

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "trainings")
data class TrainingsEntity(
    @PrimaryKey (autoGenerate = true) @ColumnInfo(name = "ID") val training_id : Int = 1,
    @ColumnInfo (name = "TIMESTAMP") val training_timestamp : String,
    @ColumnInfo (name = "EXERCISE_ID") val exercise_id : Int = 1
):Parcelable