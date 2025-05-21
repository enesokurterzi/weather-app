package com.example.weatherapp.data.remote.dailyweather

import retrofit2.http.GET
import retrofit2.http.Query

interface DailyWeatherService {

    @GET("v1/forecast?daily=weathercode,temperature_2m_max,temperature_2m_min&timezone=auto")
    suspend fun getDailyWeatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
    ): DailyWeatherDto
}