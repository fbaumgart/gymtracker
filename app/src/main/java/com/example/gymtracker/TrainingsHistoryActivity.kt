package com.example.gymtracker

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TrainingsHistoryActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trainingshistory)
        supportActionBar?.title = "Choose training to display"
        val listView = findViewById<ListView>(R.id.trainingsHistoryListView)
        val textView = findViewById<TextView>(R.id.noTrainingsTextView)
        val db = AppDatabase.getAppDatabase(applicationContext)
        val trainingsToDisplay = db.trainingsDao().getDistinctTrainings()
        var trainingsArray : ArrayList<String> = ArrayList()
        var trainingIDsArray : ArrayList<Int> = ArrayList()
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

        if (trainingsArray.isEmpty()){
            textView.visibility = VISIBLE
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val trainingID = trainingIDsArray[position]
            println(trainingID)
            val intent = Intent(this, SingleTrainingHistoryActivity::class.java)
            intent.putExtra("trainingID", trainingID)
            startActivity(intent)
        }
    }
}