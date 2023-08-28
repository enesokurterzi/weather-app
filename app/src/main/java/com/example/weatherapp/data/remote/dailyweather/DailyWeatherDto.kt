package com.example.weatherapp.data.remote.dailyweather

import com.squareup.moshi.Json

data class DailyWeatherDto(
    @field:Json(name = "daily")
    val dailyWeatherData: DailyWeatherDataDto
)
