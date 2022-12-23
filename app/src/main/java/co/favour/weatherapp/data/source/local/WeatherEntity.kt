package co.favour.weatherapp.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.favour.weatherapp.model.WeatherData

//Model
@Entity
class WeatherEntity(
    @PrimaryKey
    val timeInMillInUTC: Long,
    val city: String,
    val country: String,
    val temp: Double,
    val tempFeelsLike: Double,
    val minTemp: Double,
    val maxTemp: Double,
    val humidity: Double,
    val uvIndex: String,
    val windSpeed: Double,
    val weatherDescription: String,
    val weatherCondition: String,
    val icon: String,
    val metric: String,
)

//Mapper
fun WeatherEntity.toWeatherData(): WeatherData {
    return WeatherData(
        timeInMills = timeInMillInUTC,
        location = city,
        country = country,
        temprature = temp,
        feelsLike = tempFeelsLike,
        minTemprature = minTemp,
        maxTemp = maxTemp,
        humidity = humidity,
        uvIndex = uvIndex,
        windSpeed = windSpeed,
        weatherDescription = weatherDescription,
        weatherCondition = weatherCondition,
        metric = metric,
        icon = icon)
}