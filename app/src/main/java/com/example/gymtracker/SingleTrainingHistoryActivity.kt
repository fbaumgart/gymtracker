package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class SingleTrainingHistoryActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val intent = Intent(this, TrainingsHistoryActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trainings_history_training_details)
        supportActionBar?.title = "Training details"
        val trainingID = intent.getIntExtra("trainingID", 0)
        val listView: ListView = findViewById<ListView>(R.id.singleTrainingHistoryListView)
        val db = AppDatabase.getAppDatabase(applicationContext)
        val exercisesToDisplay = db.trainingsDao().getExercisesFromTraining(trainingID)
        val exercisesArray = ArrayList(exercisesToDisplay)
        val adapter = SingleTrainingHistoryListAdapter(
            this,
            R.layout.new_training_single_exercise_item,
            exercisesArray
        )
        listView.adapter = adapter
        if (exercisesToDisplay.isEmpty()) {
            val intent = Intent(this, TrainingsHistoryActivity::class.java)
            startActivity(intent)
        }
        val trainingDateTime = exercisesToDisplay[0].training_date + " " + exercisesToDisplay[0].training_time
        val textView : TextView = findViewById(R.id.trainingHistoryDateTime)
        textView.text = trainingDateTime
    }
}