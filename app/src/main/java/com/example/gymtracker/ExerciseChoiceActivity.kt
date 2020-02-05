package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter

import android.widget.ListView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity

class ExerciseChoiceActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_training_exercise_choice_listview)
        supportActionBar?.title = "Choose exercise"
        val currentTrainingID :Int? = intent.getIntExtra("currentTrainingID", 0)
        val listView: ListView = findViewById(R.id.exercisesListView)
        val exercisesArray = resources.getStringArray(R.array.exercises)
        val adapter = ArrayAdapter<String>(this, R.layout.exercise_choice_single_exercise, exercisesArray)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val exerciseName = adapter.getItem(position)
            val intent = Intent(this, ExerciseSetDetailsActivity::class.java)
            if (currentTrainingID != 0) {
                intent.putExtra("currentTrainingID", currentTrainingID)
            }
            intent.putExtra("Exercise", exerciseName)
            startActivity(intent)
        }

    }
}