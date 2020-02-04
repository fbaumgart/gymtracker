package com.example.gymtracker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ExercisesListAdapter(context: Context, resource: Int, objects: ArrayList<ExercisesFromTraining>) :
    ArrayAdapter<ExercisesFromTraining>(context, resource, objects) {

    private val mResource = resource
    private val mContext = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val id : Int = getItem(position).id
        val exerciseName : String = getItem(position).exercise_name
        val reps : String = getItem(position).reps
        val weight : String = getItem(position).weight

        val exerciseInstance = ExercisesFromTraining(id, exerciseName, reps, weight)
        val inflater = LayoutInflater.from(mContext)
        val convertView = inflater.inflate(mResource, parent, false)

        val exerciseNameTV : TextView = convertView.findViewById(R.id.trainingExerciseName)
        val repsValueTV : TextView = convertView.findViewById(R.id.trainingRepsValue)
        val weightValueTV : TextView = convertView.findViewById(R.id.trainingWeightValue)
        val deleteButton : Button = convertView.findViewById(R.id.deleteExerciseButton)

        deleteButton.setOnClickListener{
            println(id)
            val db = AppDatabase.getAppDatabase(context)
            //TODO: Implement delete from database
            notifyDataSetChanged()
            val intent = Intent(context, NewTrainingActivity::class.java)
            Activity().startActivity(intent)
        }


        exerciseNameTV.setText(exerciseName)
        repsValueTV.setText(reps)
        weightValueTV.setText(weight)

        return convertView
    }
}