package com.example.gymtracker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ExerciseSetDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercise_choice_details)
        supportActionBar?.title = "Add exercise to training list"
        val exerciseNameFromPreviousActivity= intent.getStringExtra("Exercise")
        val exerciseNameTextView = findViewById<TextView>(R.id.detailsExerciseName)
        exerciseNameTextView.setText(exerciseNameFromPreviousActivity)
    }
}