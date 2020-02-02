package com.example.gymtracker


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "trainings")
data class TrainingsEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "ID") val id : Int,
    @ColumnInfo (name = "TRAINING_ID") val training_id : Int,
    @ColumnInfo (name = "TIMESTAMP") val training_timestamp : String,
    @ColumnInfo (name = "REPS") val reps : Int,
    @ColumnInfo (name = "WEIGHT") val weight : Int,
    @ColumnInfo (name = "EXERCISE_NAME") val exercise_name : String
):Parcelable

data class MaxID(
    @ColumnInfo(name = "MAX_ID") val training_id: Int
)