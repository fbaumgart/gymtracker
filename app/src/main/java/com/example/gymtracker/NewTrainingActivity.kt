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
        addExerciseBtn.setOnClickListener{

                val builder = AlertDialog.Builder(this)
                val array: Array<String> = resources.getStringArray(R.array.exercises)

                builder.setSingleChoiceItems(
                    array,
                    -1
                ) { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                builder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }

                val mDialog = builder.create()
                mDialog.show()

        }
    }
}
