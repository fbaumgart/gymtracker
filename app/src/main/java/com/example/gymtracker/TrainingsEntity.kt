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
    @ColumnInfo (name = "DATE") val training_date : String?,
    @ColumnInfo (name = "TIME") val training_time : String?,
    @ColumnInfo (name = "REPS") val reps : Int,
    @ColumnInfo (name = "WEIGHT") val weight : Int,
    @ColumnInfo (name = "EXERCISE_NAME") val exercise_name : String
):Parcelable

data class ExercisesFromTraining(
    @ColumnInfo (name = "ID") val id : Int,
    @ColumnInfo (name = "TRAINING_ID") val training_id: Int,
    @ColumnInfo (name = "EXERCISE_NAME") val exercise_name: String,
    @ColumnInfo (name = "REPS") val reps: String,
    @ColumnInfo (name = "WEIGHT") val weight: String,
    @ColumnInfo (name = "DATE") val training_date : String?,
    @ColumnInfo (name = "TIME") val training_time : String?
)

data class DistinctTrainingsList(
    @ColumnInfo (name = "TRAINING_ID") val training_id: Int,
    @ColumnInfo (name = "DATE") val training_date : String,
    @ColumnInfo (name = "TIME") val training_time : String
)

data class WeightsOrderedByDate(
    @ColumnInfo (name = "WEIGHT") val weight: Int,
    @ColumnInfo (name = "DATE") val training_date : String
)