package com.example.gymtracker

import android.os.Bundle

import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ExerciseChoiceActivity : AppCompatActivity(){

    //TODO: apply https://developer.android.com/reference/android/app/ListActivity.html

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_training_exercise_choice_listview)
        var listView: ListView = findViewById(R.id.exercisesListView)
        listView.setOnClickListener(TODO("uzupełnić"))

    }
}