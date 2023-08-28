package com.example.weatherapp.data.remote.dailyweather

import com.squareup.moshi.Json

data class DailyWeatherDataDto(
    @field:Json(name = "time")
    val dailyTime: List<String>,
    @field:Json(name = "weathercode")
    val dailyWeatherCodes: List<Int>,
    @field:Json(name = "temperature_2m_max")
    val dailyMaxTemperatures: List<Double>,
    @field:Json(name = "temperature_2m_min")
    val dailyMinTemperatures: List<Double>
)
