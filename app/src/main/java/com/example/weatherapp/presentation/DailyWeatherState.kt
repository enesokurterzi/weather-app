package com.example.weatherapp.presentation

import com.example.weatherapp.domain.local.dailyweather.DailyWeatherInfo

data class DailyWeatherState(
    val dailyWeatherInfo: DailyWeatherInfo? = null
)
