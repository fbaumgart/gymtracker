package com.example.gymtracker

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class ResultsGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.results_graph_activity)
        val lineChart = findViewById<LineChart>(R.id.chart)
        val exerciseName = intent.getStringExtra("exerciseName")
        val db = AppDatabase.getAppDatabase(applicationContext)
        val exerciseWeightsOrderedByDate = db.trainingsDao().getWeightsOrderedByDate(exerciseName)
        val entries = ArrayList<Entry>()
        val labels = ArrayList<String>()
        var index: Float = 0f
        exerciseWeightsOrderedByDate.forEach {
            labels.add(it.training_date)
            val entry: Entry = Entry(index, it.weight.toFloat())
            entries.add(entry)
            index += 1
        }
        val entriesDataset = LineDataSet(entries, "Weight")
        entriesDataset.setAxisDependency(YAxis.AxisDependency.LEFT)
        entriesDataset.setLineWidth(3f)
        entriesDataset.setDrawCircles(false)
        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(entriesDataset)
        val data = LineData(dataSets)
        lineChart.data = data
        val formatter = object : ValueFormatter() {
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return labels[value.toInt()]
            }
        }
        val xAxis = lineChart.xAxis
        xAxis.granularity = 1f
        xAxis.valueFormatter = formatter
        val description = Description()
        description.text = ""
        lineChart.description = description
        lineChart.setPadding(10, 10, 10, 10)
        lineChart.invalidate()
    }
}