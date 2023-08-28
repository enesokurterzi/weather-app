package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.local.dailyweather.DailyWeatherInfo
import com.example.weatherapp.domain.util.Resource

interface DailyWeatherRepository {
    suspend fun getDailyWeatherData(lat: Double, long: Double): Resource<DailyWeatherInfo>
}