package com.example.weatherapp.data.repository

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.mappers.toWeatherInfo
import com.example.weatherapp.data.remote.weather.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import com.example.weatherapp.domain.local.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

}