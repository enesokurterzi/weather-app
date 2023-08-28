package com.example.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.local.dailyweather.DailyWeatherData

@Composable
fun DailyWeatherDisplay(
    dailyWeatherData: DailyWeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = dailyWeatherData.dailyWeatherCode.iconRes),
            contentDescription = dailyWeatherData.dailyWeatherCode.weatherDesc,
            modifier = Modifier.width(40.dp)
        )
    }
}