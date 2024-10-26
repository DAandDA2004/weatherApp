package com.example.singlelinechart

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.singlelinechart.ui.theme.SingleLineChartTheme
import kotlin.random.Random

const val steps = 10
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val pointsList = getPointsList()
            val max = getMax(pointsList)
            val min = getMin(pointsList)
            Log.d("MyLog", "Max: $max Min: $min")
            val xAxisData = AxisData.Builder()
                .axisStepSize(100.dp)
                .backgroundColor(Color.Transparent)
                .steps(pointsList.size - 1)
                .labelData { i -> i.toString() + "d"}
                .labelAndAxisLinePadding(15.dp)
                .build()

            val yAxisData = AxisData.Builder()
                .steps(steps)
                .backgroundColor(Color.Transparent)
                .labelAndAxisLinePadding(20.dp)
                .labelData {
                    i ->
                    val yScale = (max - min) / steps.toFloat()
                    String.format("%.1f", ((i * yScale) + min))
                }.build()

            SingleLineChartTheme {
                val lineChartData = LineChartData(
                    linePlotData = LinePlotData(
                        lines = listOf(
                            Line(
                                dataPoints = pointsList,
                                LineStyle(color = Color.Green, width = 1.0f),
                                IntersectionPoint(color = Color.Blue, radius = 3.dp),
                                SelectionHighlightPoint(),
                                ShadowUnderLine(),
                                SelectionHighlightPopUp()
                            )
                        ),
                    ),
                    xAxisData = xAxisData,
                    yAxisData = yAxisData,
                    gridLines = GridLines(),
                    backgroundColor = Color.White
                )

                LineChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    lineChartData = lineChartData
                )
            }
        }
    }

    fun getPointsList(): List<co.yml.charts.common.model.Point> {
        val list = ArrayList<co.yml.charts.common.model.Point>()
        for (i in 0..31) {
            list.add(
                co.yml.charts.common.model.Point(
                    i.toFloat(),
                    Random.nextInt(50, 90).toFloat()
                )
            )
        }
        return list
    }

    private fun getMax(pointsList: List<co.yml.charts.common.model.Point>): Float {
        var max = 0f
        pointsList.forEach { point ->
            if (max < point.y) max = point.y
        }
        return max
    }

    private fun getMin(pointsList: List<co.yml.charts.common.model.Point>): Float {
        var min = 0f
        pointsList.forEach { point ->
            if (min > point.y) min = point.y
        }
        return min
    }
}

