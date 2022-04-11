package com.damco.weather.sdk.utils

import com.damco.weather.sdk.WeatherSDK

object Utils {
    fun getConvertedUnit(tempUnit: WeatherSDK.TempUnit): String {
        return when (tempUnit.name) {
            WeatherSDK.TempUnit.CELSIUS.name -> {
                "metric"
            }
            WeatherSDK.TempUnit.FAHRENHEIT.name -> {
                "imperial"
            }
            else -> {
                "standard"
            }
        }
    }

}