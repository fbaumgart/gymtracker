package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class TrainingsHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainingshistory)
        supportActionBar?.title = "Choose training to display"
        val listView = findViewById<ListView>(R.id.trainingsHistoryListView)
        val db = AppDatabase.getAppDatabase(applicationContext)
        val trainingsToDisplay = db.trainingsDao().getDistinctTrainings()
        var trainingsArray : ArrayList<String> = ArrayList<String>()
        var trainingIDsArray : ArrayList<Int> = ArrayList<Int>()
        trainingsToDisplay.forEach{
            val trainingID = it.training_id
            val trainingDate = it.training_date
            val trainingTime = it.training_time
            val builder = StringBuilder()
            builder.append(trainingDate)
                .append(" ")
                .append(trainingTime)
            val trainingDateTime = builder.toString()
            trainingsArray.add(trainingDateTime)
            trainingIDsArray.add(trainingID)
        }
        val adapter = ArrayAdapter<String>(this, R.layout.trainings_history_single_training_item, trainingsArray)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val trainingID = trainingIDsArray[position]
            val trainingDateTime = adapter.getItem(position)
            println(trainingID)
            val intent = Intent(this, ExerciseSetDetailsActivity::class.java)
            intent.putExtra("trainingID", trainingID)
            intent.putExtra("trainingDateTime", trainingDateTime)
            startActivity(intent)
        }
    }
}