package com.example.gymtracker

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newTrainingBtn: Button = findViewById(R.id.newTrainingButton)
        newTrainingBtn.setOnClickListener {
            val intent = Intent(this, NewTrainingActivity::class.java)
            startActivity(intent)


        }
    }
}


