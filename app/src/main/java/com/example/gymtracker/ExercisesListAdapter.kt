package com.example.gymtracker


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView


class ExercisesListAdapter(
    context: Context,
    resource: Int,
    objects: ArrayList<ExercisesFromTraining>
) :
    ArrayAdapter<ExercisesFromTraining>(context, resource, objects) {

    private val mResource = resource
    private val mContext = context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val id: Int = getItem(position).id
        val trainingId: Int = getItem(position).training_id
        val exerciseName: String = getItem(position).exercise_name
        val reps: String = getItem(position).reps
        val weight: String = getItem(position).weight

        //val exerciseInstance = ExercisesFromTraining(id, trainingId, exerciseName, reps, weight)
        val inflater = LayoutInflater.from(mContext)
        val convertView = inflater.inflate(mResource, parent, false)

        val exerciseNameTV: TextView = convertView.findViewById(R.id.trainingExerciseName)
        val repsValueTV: TextView = convertView.findViewById(R.id.trainingRepsValue)
        val weightValueTV: TextView = convertView.findViewById(R.id.trainingWeightValue)
        val deleteButton: Button = convertView.findViewById(R.id.deleteExerciseButton)

        deleteButton.setOnClickListener {
            println(id)
            val db = AppDatabase.getAppDatabase(context)
            db.trainingsDao().deleteExerciseFromTraining(id)
            notifyDataSetChanged()
            val intent = Intent(context, NewTrainingActivity::class.java)
            intent.putExtra("currentTrainingID", trainingId)
            context.startActivity(intent)
        }

        exerciseNameTV.text = exerciseName
        repsValueTV.text = reps
        weightValueTV.text = weight

        return convertView
    }
}