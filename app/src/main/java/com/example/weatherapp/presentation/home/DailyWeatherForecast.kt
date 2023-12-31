package com.example.weatherapp.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.WeatherState

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyWeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.dailyWeatherInfo?.weatherDataDaily?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Daily",
                fontSize = 20.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) {dailyWeatherData ->
                    DailyWeatherDisplay(
                        dailyWeatherData = dailyWeatherData,
                        modifier = Modifier
                            .height(110.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            })
        }
    }
}