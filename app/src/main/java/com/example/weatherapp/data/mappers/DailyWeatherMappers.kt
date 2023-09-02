package com.example.weatherapp.data.mappers

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.remote.dailyweather.DailyWeatherDataDto
import com.example.weatherapp.data.remote.dailyweather.DailyWeatherDto
import com.example.weatherapp.domain.local.WeatherType
import com.example.weatherapp.domain.local.dailyweather.DailyWeatherData
import com.example.weatherapp.domain.local.dailyweather.DailyWeatherInfo
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun DailyWeatherDataDto.toDailyWeatherDataMap(): List<DailyWeatherData> {
    return dailyTime.mapIndexed {index, time ->
        val dailyMaxTemperature = dailyMaxTemperatures[index]
        val dailyMinTemperature = dailyMinTemperatures[index]
        val dailyWeatherCode = dailyWeatherCodes[index]
            DailyWeatherData(
                dailyTime = LocalDate.parse(time),
                dailyMaxTemperature = dailyMaxTemperature,
                dailyMinTemperature = dailyMinTemperature,
                dailyWeatherCode = WeatherType.fromWMO(dailyWeatherCode)
            )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun DailyWeatherDto.toDailyWeatherInfo(): DailyWeatherInfo {
    val dailyWeatherDataMap = dailyWeatherData.toDailyWeatherDataMap()

    return DailyWeatherInfo(
        weatherDataDaily = dailyWeatherDataMap
    )
}