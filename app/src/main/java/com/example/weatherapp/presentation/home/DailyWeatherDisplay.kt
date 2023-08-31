package com.example.weatherapp.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.local.dailyweather.DailyWeatherData
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DailyWeatherDisplay(
    dailyWeatherData: DailyWeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedDay = remember (dailyWeatherData) {
        dailyWeatherData.dailyTime.format(
            DateTimeFormatter.ofPattern("dd/MM")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedDay,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = dailyWeatherData.dailyWeatherCode.iconRes),
            contentDescription = dailyWeatherData.dailyWeatherCode.weatherDesc,
            modifier = Modifier.width(40.dp)
        )
        Column {
            Text(
                text = "${dailyWeatherData.dailyMaxTemperature}°C",
                color = textColor,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${dailyWeatherData.dailyMinTemperature}°C",
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
            )
        }
    }
}