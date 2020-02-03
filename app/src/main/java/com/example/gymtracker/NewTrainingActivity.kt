package com.example.gymtracker

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewTrainingActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtraining)
        supportActionBar?.title = "New training"

        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy    HH:mm")
        val formattedCurrentDateTime = currentDateTime.format(formatter)
        val currentTrainingID :Int? = intent.getIntExtra("currentTrainingID", 0)

        if (currentTrainingID != 0){
            //val listView: ListView = findViewById(R.id.newTrainingExercisesListView)
            println(currentTrainingID)
            //TODO("if currentTrainingID has been passed from ExerciseChoiceActivity then display ListView with the records from db that has the same TRAINING_ID")
        }

        var newTrainingDayTimeTextView: TextView = findViewById<TextView>(R.id.newTrainingDayTime)
        newTrainingDayTimeTextView.append("    " + formattedCurrentDateTime)

        val addExerciseBtn: Button = findViewById(R.id.addExerciseButton)
        val endTrainingBtn: Button = findViewById(R.id.endTrainingButton)

        addExerciseBtn.setOnClickListener {
            val intent = Intent(this, ExerciseChoiceActivity::class.java)
            if (currentTrainingID != 0) {
                intent.putExtra("currentTrainingID", currentTrainingID)
            }
            startActivity(intent)
        }
        endTrainingBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
