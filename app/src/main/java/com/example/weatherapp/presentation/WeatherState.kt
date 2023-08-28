package com.example.weatherapp.presentation

import com.example.weatherapp.domain.local.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
