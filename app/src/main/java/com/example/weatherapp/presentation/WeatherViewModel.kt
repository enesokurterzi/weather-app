package com.example.weatherapp.presentation

import android.location.Location
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.domain.location.LocationTracker
import com.example.weatherapp.domain.repository.DailyWeatherRepository
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val dailyWeatherRepository: DailyWeatherRepository,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->

                launch {
                    launch { loadWeatherInfo(location) }
                    launch { loadDailyWeatherInfo(location) }
                }
                    .invokeOnCompletion {
                        state = state.copy(isLoading = false)
                    }

            } ?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }

    private suspend fun loadDailyWeatherInfo(location: Location) {
        when (val result =
            dailyWeatherRepository.getDailyWeatherData(location.latitude, location.longitude)) {
            is Resource.Success -> {
                state = state.copy(
                    dailyWeatherInfo = result.data,

                )
            }

            is Resource.Error -> {
                state = state.copy(
                    dailyWeatherInfo = result.data
                )

            }
        }

    }

    private suspend fun loadWeatherInfo(location: Location) {
        when (val result = repository.getWeatherData(location.latitude, location.longitude)) {
            is Resource.Success -> {
                state = state.copy(
                    weatherInfo = result.data,
                    error = null
                )
            }

            is Resource.Error -> {
                state = state.copy(
                    weatherInfo = null,
                    error = result.message
                )

            }

        }
    }

}