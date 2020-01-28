package com.example.gymtracker

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class ExerciseChoiceActivity : AppCompatActivity(){

    //TODO: apply https://developer.android.com/reference/android/app/ListActivity.html

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercises_list)
        var listView: ListView = findViewById(R.id.exercisesListView)
        listView.setOnClickListener()

    }
}