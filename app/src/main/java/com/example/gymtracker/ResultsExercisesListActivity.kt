package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ResultsExercisesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Choose exercise to draw a graph"
        setContentView(R.layout.results_exercises_list_activity)

        val db = AppDatabase.getAppDatabase(applicationContext)

        val listView = findViewById<ListView>(R.id.resultsExercisesListView)
        val exercisesList = db.trainingsDao().getAvailableExercises()
        val adapter = ArrayAdapter<String>(this, R.layout.exercise_choice_single_exercise, exercisesList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val exerciseName = adapter.getItem(position)
            val intent = Intent(this, ResultsGraphActivity::class.java)
            intent.putExtra("exerciseName", exerciseName)
            startActivity(intent)
        }
    }
}