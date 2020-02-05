package com.example.gymtracker


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import com.example.gymtracker.AppDatabase as AppDatabase

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newTrainingBtn: Button = findViewById(R.id.newTrainingButton)
        val trainingHistoryBtn: Button = findViewById(R.id.trainingLogButton)
        val resultsBtn: Button = findViewById(R.id.resultsButton)

        newTrainingBtn.setOnClickListener {
            val intent = Intent(this, NewTrainingActivity::class.java)
            startActivity(intent)
        }

        /*
        trainingHistoryBtn.setOnClickListener {
            val intent = Intent(this, TODO("utworzyć i wpisać klasę")::class.java)
            startActivity(intent)
        }

        resultsBtn.setOnClickListener {
            val intent = Intent(this, TODO("utworzyć i wpisać klasę")::class.java)
            startActivity(intent)
        }
*/
    }
}


