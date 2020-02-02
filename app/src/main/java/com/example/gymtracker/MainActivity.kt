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

class MainActivity : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize Room DB
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "AppDatabase.db"
        ).allowMainThreadQueries().build()

        val newTrainingBtn: Button = findViewById(R.id.newTrainingButton)
        val trainingHistoryBtn: Button = findViewById(R.id.trainingLogButton)
        val resultsBtn: Button = findViewById(R.id.resultsButton)

        newTrainingBtn.setOnClickListener {
            val intent = Intent(this, NewTrainingActivity::class.java)
            var maxID = db.trainingsDao().getMaxTrainingID()
            val newTrainingID = maxID + 1
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



        //val currentDateTime = LocalDateTime.now()
        //val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm")
        //val formattedCurrentDateTime = currentDateTime.format(formatter)

        //Testing Database
       // db.trainingsDao().insertTraining(TrainingsEntity(5, 10, formattedCurrentDateTime, 5, 10, "Deadlift"))
       // val allTrainingsList = db.trainingsDao().getAllTrainings()
       // allTrainingsList?.forEach{
       //     println("Query result")
       //     println(it)
       // }

        var maxID = db.trainingsDao().getMaxTrainingID()
        println("MAX ID  ${maxID}")
        val newTrainingID = maxID + 1
        println("MAX ID  ${newTrainingID}")
    }
}


