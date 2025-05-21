package com.example.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.mappers.toDailyWeatherInfo
import com.example.weatherapp.data.remote.dailyweather.DailyWeatherService
import com.example.weatherapp.domain.local.dailyweather.DailyWeatherInfo
import com.example.weatherapp.domain.repository.DailyWeatherRepository
import com.example.weatherapp.domain.util.Resource
import javax.inject.Inject

class DailyWeatherRepositoryImpl @Inject constructor(
    private val dailyWeatherService: DailyWeatherService
): DailyWeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getDailyWeatherData(
        lat: Double,
        long: Double
    ): Resource<DailyWeatherInfo> {
        return try {
            Resource.Success(
                data = dailyWeatherService.getDailyWeatherData(
                    lat = lat,
                    long = long
                ).toDailyWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

}
