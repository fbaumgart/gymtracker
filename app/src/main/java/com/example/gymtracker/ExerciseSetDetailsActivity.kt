package com.example.gymtracker

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ExerciseSetDetailsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_choice_details)
        supportActionBar?.title = "Add exercise to training list"

        val exerciseNameFromPreviousActivity = intent.getStringExtra("Exercise")
        val currentTrainingID: Int = intent.getIntExtra("currentTrainingID", 0)

        val exerciseNameTextView = findViewById<TextView>(R.id.detailsExerciseName)
        exerciseNameTextView.text = exerciseNameFromPreviousActivity
        val db = AppDatabase.getAppDatabase(applicationContext)
        val addExerciseBtn: Button = findViewById<Button>(R.id.detailsAddExerciseButton)


        addExerciseBtn.setOnClickListener {
            val repsValue: Int =
                findViewById<EditText>(R.id.detailsRepsValue).text.toString().toInt()
            val weightValue: Int =
                findViewById<EditText>(R.id.detailsWeightValue).text.toString().toInt()
            val newTrainingID: Int

            if (currentTrainingID != 0) {
                newTrainingID = currentTrainingID
            } else
            {
                val maxTrainingID = db.trainingsDao().getMaxTrainingID()
                newTrainingID = maxTrainingID + 1
            }

            val maxID = db.trainingsDao().getMaxID()
            val newID = maxID + 1
            val currentDateTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm")
            val formattedCurrentDateTime = currentDateTime.format(formatter)
            db.trainingsDao().insertTraining(
                TrainingsEntity(
                    newID,
                    newTrainingID,
                    formattedCurrentDateTime,
                    repsValue,
                    weightValue,
                    exerciseNameFromPreviousActivity
                )
            )

            val intent = Intent(this, NewTrainingActivity::class.java)
            intent.putExtra("currentTrainingID", newTrainingID)

            if (currentTrainingID != 0) {
                intent.putExtra("currentTrainingID", currentTrainingID)
            }

            startActivity(intent)
        }
    }
}