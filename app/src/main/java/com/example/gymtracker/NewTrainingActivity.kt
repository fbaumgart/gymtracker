package com.example.gymtracker

import android.app.AlertDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_newtraining.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewTrainingActivity : AppCompatActivity(){
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newtraining)

        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy    HH:mm")
        val formattedCurrentDateTime = currentDateTime.format(formatter)

        var newTrainingDayTimeTextView : TextView = findViewById<TextView>(R.id.newTrainingDayTime)
        newTrainingDayTimeTextView.append("    " + formattedCurrentDateTime)

        val addExerciseBtn : Button = findViewById(R.id.addExerciseButton)
        val endTrainingBtn : Button = findViewById(R.id.endTrainingButton)

        addExerciseBtn.setOnClickListener{
            val intent = Intent(this, ExerciseChoiceActivity::class.java)
            startActivity(intent)
        }
        endTrainingBtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
