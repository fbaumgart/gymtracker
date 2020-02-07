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

    var pressCounter = 0
    override fun onBackPressed() {
        pressCounter += 1
        if (pressCounter == 2){
            finishAndRemoveTask()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newTrainingBtn: Button = findViewById(R.id.newTrainingButton)
        val trainingsHistoryBtn: Button = findViewById(R.id.trainingsHistoryButton)
        val resultsBtn: Button = findViewById(R.id.resultsButton)

        newTrainingBtn.setOnClickListener {
            /*val db = AppDatabase.getAppDatabase(applicationContext)
            db.trainingsDao().insertTraining(TrainingsEntity(1, 1, "01-01-2020", "07:00", 10, 50, "Bench press"))
            db.trainingsDao().insertTraining(TrainingsEntity(2, 1, "01-01-2020", "07:00", 11, 70, "Deadlift"))
            db.trainingsDao().insertTraining(TrainingsEntity(3, 1, "01-01-2020", "07:00", 12, 20, "Bent over row"))
            db.trainingsDao().insertTraining(TrainingsEntity(4, 1, "01-01-2020", "07:00", 13, 30, "Military press"))
            db.trainingsDao().insertTraining(TrainingsEntity(5, 1, "01-01-2020", "07:00", 14, 60, "Barbell squat"))

            db.trainingsDao().insertTraining(TrainingsEntity(6, 2, "13-03-2020", "12:32", 10, 55, "Bench press"))
            db.trainingsDao().insertTraining(TrainingsEntity(7, 2, "13-03-2020", "12:32", 11, 75, "Deadlift"))
            db.trainingsDao().insertTraining(TrainingsEntity(8, 2, "13-03-2020", "12:32", 12, 25, "Bent over row"))
            db.trainingsDao().insertTraining(TrainingsEntity(9, 2, "13-03-2020", "12:32", 13, 35, "Military press"))
            db.trainingsDao().insertTraining(TrainingsEntity(10, 2, "13-03-2020", "12:32", 14, 65, "Barbell squat"))

            db.trainingsDao().insertTraining(TrainingsEntity(11, 3, "24-06-2020", "22:16", 10, 60, "Bench press"))
            db.trainingsDao().insertTraining(TrainingsEntity(12, 3, "24-06-2020", "22:16", 11, 80, "Deadlift"))
            db.trainingsDao().insertTraining(TrainingsEntity(13, 3, "24-06-2020", "22:16", 12, 30, "Bent over row"))
            db.trainingsDao().insertTraining(TrainingsEntity(14, 3, "24-06-2020", "22:16", 13, 40, "Military press"))
            db.trainingsDao().insertTraining(TrainingsEntity(15, 3, "24-06-2020", "22:16", 14, 70, "Barbell squat"))

            db.trainingsDao().insertTraining(TrainingsEntity(16, 4, "31-10-2020", "17:49", 10, 65, "Bench press"))
            db.trainingsDao().insertTraining(TrainingsEntity(17, 4, "31-10-2020", "17:49", 11, 85, "Deadlift"))
            db.trainingsDao().insertTraining(TrainingsEntity(18, 4, "31-10-2020", "17:49", 12, 35, "Bent over row"))
            db.trainingsDao().insertTraining(TrainingsEntity(19, 4, "31-10-2020", "17:49", 13, 45, "Military press"))
            db.trainingsDao().insertTraining(TrainingsEntity(20, 4, "31-10-2020", "17:49", 14, 75, "Barbell squat"))*/
            val intent = Intent(this, NewTrainingActivity::class.java)
            startActivity(intent)
        }

        trainingsHistoryBtn.setOnClickListener {
            val intent = Intent(this, TrainingsHistoryActivity::class.java)
            startActivity(intent)
        }

        resultsBtn.setOnClickListener {
           val intent = Intent(this, ResultsExercisesListActivity::class.java)
           startActivity(intent)
        }
    }
}


