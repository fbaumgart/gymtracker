package com.example.gymtracker

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment

class ExerciseChoiceDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            val array: Array<String> = resources.getStringArray(R.array.exercises)

            // Set the dialog title
            builder.setTitle(R.string.exercise_choice)

                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(array, 0,
                    DialogInterface.OnClickListener { dialogInterface: DialogInterface, i: Int ->
                        @Override
                        fun onClick(dialogInterface: DialogInterface,i : Int){
                        }
                    })
                // Set the action buttons
                .setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK, so save the selectedItems results somewhere
                        // or return them to the component that opened the dialog
                        //TODO:
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        //TODO:
                    })

            builder.create()
            builder.show()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}