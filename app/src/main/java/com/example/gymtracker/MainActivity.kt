package com.example.gymtracker

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(){

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
        trainingHistoryBtn.setOnClickListener {
            val intent = Intent(this, TODO("utworzyć i wpisać klasę")::class.java)
            startActivity(intent)
        }
        resultsBtn.setOnClickListener {
            val intent = Intent(this, TODO("utworzyć i wpisać klasę")::class.java)
            startActivity(intent)
        }
    }
}


