package com.example.gymtracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import org.w3c.dom.Text

class ExercisesListAdapter(context: Context, resource: Int, objects: ArrayList<ExercisesFromTraining>) :
    ArrayAdapter<ExercisesFromTraining>(context, resource, objects) {

    val mResource = resource
    val mContext = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val exerciseName : String = getItem(position).exercise_name
        val reps : String = getItem(position).reps
        val weight : String = getItem(position).weight

        val exerciseInstance = ExercisesFromTraining(exerciseName, reps, weight)
        val inflater = LayoutInflater.from(context)
        val convertView = inflater.inflate(mResource, parent, false)

        val exerciseNameTV : TextView = convertView.findViewById(R.id.trainingExerciseName)
        val repsValueTV : TextView = convertView.findViewById(R.id.trainingRepsValue)
        val weightValueTV : TextView = convertView.findViewById(R.id.trainingWeightValue)

        exerciseNameTV.setText(exerciseName)
        repsValueTV.setText(reps)
        weightValueTV.setText(weight)

        return convertView
    }
}