package com.damco.weather.sdk.data

import com.damco.weather.sdk.data.model.weather.WeatherResponse
import io.reactivex.Single

internal interface DataSource {

    fun getCurrentWeather(
        latitude: Double,
        longitude: Double,
        tempUnit: String,
        apiKey: String
    ): Single<WeatherResponse>

}