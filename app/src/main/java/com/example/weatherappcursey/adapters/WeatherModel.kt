package com.example.weatherappcursey.adapters

import android.service.notification.Condition

data class WeatherModel (
    val city: String,
    val time: String,
    val condition: String,
    val currentTemp: String,
    val maxTemp: String,
    val minTemp: String,
    val imageUrl: String,
    val hours: String
)