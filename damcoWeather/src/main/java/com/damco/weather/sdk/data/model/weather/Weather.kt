package com.damco.weather.sdk.data.model.weather

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)