package com.example.weatherapp.domain.local.dailyweather

import com.example.weatherapp.domain.local.WeatherType
import java.time.LocalDate

data class DailyWeatherData(
    val dailyTime: LocalDate,
    val dailyMaxTemperature: Double,
    val dailyMinTemperature: Double,
    val dailyWeatherCode: WeatherType
)
