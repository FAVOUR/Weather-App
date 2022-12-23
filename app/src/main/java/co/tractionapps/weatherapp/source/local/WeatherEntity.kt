package co.tractionapps.weatherapp.source.local

import androidx.room.PrimaryKey

class WeatherEntity(
    @PrimaryKey
    val id: Long,
    val city: String,
    val country: String,
    val temp: Double,
    val tempFeelsLike: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val humidity: Double,
    val uvIndex: Double,
    val windSpeed: Double,
    val weatherDescription: String,
    val weatherCondition: String,
    val timeInMillInUTC: String,
    val metric:String )